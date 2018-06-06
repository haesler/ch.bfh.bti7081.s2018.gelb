package ch.bfh.bti7081.s2018.yellow.health.ui.components.searchcontact;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaadin.data.ValueProvider;
import com.vaadin.data.HasValue.ValueChangeEvent;
import com.vaadin.data.HasValue.ValueChangeListener;
import com.vaadin.data.provider.ConfigurableFilterDataProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.event.Action.Container;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.SerializablePredicate;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Grid.ItemClick;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.HeaderCell;
import com.vaadin.ui.components.grid.HeaderRow;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.shared.ui.ValueChangeMode;

import ch.bfh.bti7081.s2018.yellow.health.models.Contact;
import ch.bfh.bti7081.s2018.yellow.health.repo.ContactRepository;


@Component
public class SearchContactViewImpl extends VerticalLayout implements SearchContactView, 
											ClickListener, ValueChangeListener<String>{

	private static final long serialVersionUID = 1L;
	
	private SearchContactPresenter presenter;

	
	public Grid<Contact> grid = new Grid(Contact.class);
	List<SearchContactViewListener> listeners = new ArrayList<SearchContactViewListener>();
	
	@Autowired
	public SearchContactViewImpl(SearchContactModel service){
		this.presenter = new SearchContactPresenter(service, this);
		
		loadView();
	}
	
	private void loadView() {
		setSizeFull();
        setMargin(false);
        setSpacing(false);
        
        grid.addItemClickListener(e -> {itemclicked(e);});
        
		final VerticalLayout layout = new VerticalLayout();
		grid.setWidth("1500px");
		grid.setHeight("600px");
		
		// Create a header row to hold column filters
		HeaderRow filterRow = grid.appendHeaderRow();
		layout.addComponent(grid);
		
        grid.setColumns("firstname", "lastname", "street", "plz", "city");
		// Set up a filter for all columns
		for (Column<Contact, ?> pid: grid.getColumns()) {
		    HeaderCell cell = filterRow.getCell(pid.getId());
		    final TextField filter = new TextField();
		    filter.setPlaceholder("Filter");
		    filter.addValueChangeListener(e -> {refresh(filter.getValue(),  pid.getValueProvider());});
		    filter.addStyleName(ValoTheme.TEXTFIELD_TINY);
		    cell.setComponent(filter);
		}

        addComponent(layout);
        setComponentAlignment(layout, Alignment.MIDDLE_CENTER);		
	}
	
	
	private void refresh(String text, ValueProvider<Contact, ?> valueProvider) {
		
		for (SearchContactViewListener listener: listeners)
			listener.filter1(text, valueProvider);
    }
	
	private void itemclicked(ItemClick<Contact> e) {
		if(e.getMouseEventDetails().isDoubleClick()) {
			for (SearchContactViewListener listener: listeners)
				listener.editContact(e.getItem());	
		}
    }	



	public void addListener(SearchContactViewListener listener){
		listeners.add(listener);
	}
	

	@Override
	public void valueChange(ValueChangeEvent<java.lang.String> event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showContacts(List<Contact> contacts) {
		// TODO Auto-generated method stub
		
	}


}
