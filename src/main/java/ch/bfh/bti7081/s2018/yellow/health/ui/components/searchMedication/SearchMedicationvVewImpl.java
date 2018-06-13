package ch.bfh.bti7081.s2018.yellow.health.ui.components.searchMedication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vaadin.data.ValueProvider;
import com.vaadin.data.HasValue.ValueChangeEvent;
import com.vaadin.data.HasValue.ValueChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Grid.ItemClick;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.HeaderCell;
import com.vaadin.ui.components.grid.HeaderRow;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import ch.bfh.bti7081.s2018.yellow.health.models.Medication;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.tabcontrol.Tabpage;


@Component
public class SearchMedicationvVewImpl extends VerticalLayout implements SearchMedicationView, 
											ClickListener, ValueChangeListener<String>{

	private static final long serialVersionUID = 1L;
	
	private SearchMedicationPresenter presenter;

	
	public Grid<Medication> grid = new Grid<Medication>(Medication.class);
	List<SearchMedicationViewListener> listeners = new ArrayList<SearchMedicationViewListener>();
	
	@Autowired
	public SearchMedicationvVewImpl(SearchMedicationModel service){
		this.presenter = new SearchMedicationPresenter(service, this);
		
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
		
        grid.setColumns("medicationID","start", "end", "active");
		// Set up a filter for all columns
		for (Column<Medication, ?> pid: grid.getColumns()) {
		    HeaderCell cell = filterRow.getCell(pid.getId());
		    final TextField filter = new TextField();
		    filter.setPlaceholder("Filter");
		    filter.addValueChangeListener(e -> {refresh(filter.getValue(),  pid.getValueProvider());});
		    filter.addStyleName(ValoTheme.TEXTFIELD_TINY);
		    cell.setComponent(filter);
		}
		
		layout.setExpandRatio(grid, 1.0f);
		
		/*Button addcontact = new Button("Neuer Kontakt");
		addcontact.addClickListener(e -> {addMedicationClicked();});
		addcontact.setSizeUndefined();
		layout.addComponent(addcontact);*/

        addComponent(layout);
        setComponentAlignment(layout, Alignment.MIDDLE_CENTER);		
	}
	
	@Override
	public void addMedicationClicked() {
		for (SearchMedicationViewListener listener: listeners)
			listener.addMedicationClicked();	
		
	}

	private void refresh(String text, ValueProvider<Medication, ?> valueProvider) {
		
		for (SearchMedicationViewListener listener: listeners)
			listener.filter1(text, valueProvider);
    }
	
	private void itemclicked(ItemClick<Medication> e) {
		if(e.getMouseEventDetails().isDoubleClick()) {
			for (SearchMedicationViewListener listener: listeners)
				listener.editMedication(e.getItem());	
		}
    }	


	@Override
	public void addListener(SearchMedicationViewListener listener) {
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
	public void showMedication(List<Medication> medications) {
		// TODO Auto-generated method stub
		
	}

	public Tabpage getPresenter() {
		// TODO Auto-generated method stub
		return presenter;
	}


}
