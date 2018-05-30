package ch.bfh.bti7081.s2018.yellow.health.ui.components.searchpatient;

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

import ch.bfh.bti7081.s2018.yellow.health.models.Patient;
import ch.bfh.bti7081.s2018.yellow.health.repo.PatientRepository;


@Component
public class SearchPatientViewImpl extends VerticalLayout implements SearchPatientView, 
											ClickListener, ValueChangeListener<String>{

	private static final long serialVersionUID = 1L;
	
	private SearchPatientPresenter presenter;

	
	public Grid<Patient> grid = new Grid(Patient.class);
	List<SearchPatientViewListener> listeners = new ArrayList<SearchPatientViewListener>();
	
	@Autowired
	public SearchPatientViewImpl(SearchPatientModel service){
		this.presenter = new SearchPatientPresenter(service, this);
		
		loadView();
	}
	
	private void loadView() {
		setSizeFull();
        setMargin(false);
        setSpacing(false);
        
		final VerticalLayout layout = new VerticalLayout();
		grid.setWidth("1500px");
		grid.setHeight("600px");
		
		// Create a header row to hold column filters
		HeaderRow filterRow = grid.appendHeaderRow();
		layout.addComponent(grid);
		
        grid.setColumns("active", "end", "start");
		// Set up a filter for all columns
		for (Column<Patient, ?> pid: grid.getColumns()) {
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
	
	private void refresh(String text, ValueProvider<Patient, ?> valueProvider) {
		
		for (SearchPatientViewListener listener: listeners)
			listener.filter1(text, valueProvider);
    }



	public void addListener(SearchPatientViewListener listener){
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
	public void showPatients(List<Patient> patient) {
		// TODO Auto-generated method stub
		
	}




}
