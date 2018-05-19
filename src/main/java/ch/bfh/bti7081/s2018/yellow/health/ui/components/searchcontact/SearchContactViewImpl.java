package ch.bfh.bti7081.s2018.yellow.health.ui.components.searchcontact;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.HasValue.ValueChangeEvent;
import com.vaadin.data.HasValue.ValueChangeListener;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.shared.ui.ValueChangeMode;

import ch.bfh.bti7081.s2018.yellow.health.models.Contact;


public class SearchContactViewImpl implements SearchContactView, 
											ClickListener, ValueChangeListener<String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextField nameFilterText = new TextField();
	private TextField firstnameFilterText = new TextField();
	private TextField streetFilterText = new TextField();
	private TextField cityFilterText = new TextField();
	
	private Grid<Contact> grid = new Grid<>(Contact.class);
	
	List<SearchContactViewListener> listeners = new ArrayList<SearchContactViewListener>();
	
	public SearchContactViewImpl(){
		
		final VerticalLayout layout = new VerticalLayout();
		final VerticalLayout filtering = filterInit();

		Button addCustomerBtn = new Button("Add new customer");

        HorizontalLayout toolbar = new HorizontalLayout(filtering, addCustomerBtn);

        grid.setColumns("firstName", "lastName", "street", "plz", "city");

        layout.addComponents(toolbar, grid);	
	}

	public TextField getNameFilterText() {
		return nameFilterText;
	}

	public void setNameFilterText(TextField nameFilterText) {
		this.nameFilterText = nameFilterText;
	}

	public TextField getFirstnameFilterText() {
		return firstnameFilterText;
	}

	public void setFirstnameFilterText(TextField firstnameFilterText) {
		this.firstnameFilterText = firstnameFilterText;
	}

	public TextField getStreetFilterText() {
		return streetFilterText;
	}

	public void setStreetFilterText(TextField streetFilterText) {
		this.streetFilterText = streetFilterText;
	}

	public TextField getCityFilterText() {
		return cityFilterText;
	}

	public void setCityFilterText(TextField cityFilterText) {
		this.cityFilterText = cityFilterText;
	}

	public void showContacts(List<Contact> contacts){
		grid.setItems(contacts);
	}

	public void addListener(SearchContactViewListener listener){
		listeners.add(listener);
	}
	
	@Override
	public void clearText(TextField txtField){
		txtField.clear();
	}
	
	@Override
    public void buttonClick(ClickEvent event) {
		for (SearchContactViewListener listener: listeners)
            listener.buttonClick(event.getButton().getCaption());
    }
	
	@Override
	public void valueChange(ValueChangeEvent<String> event){
		for (SearchContactViewListener listener: listeners)
            listener.valueChange(event.getComponent().getCaption(), event.getValue());
	}
	

	public VerticalLayout filterInit(){
		VerticalLayout filtering = new VerticalLayout();
		nameFilterText.setPlaceholder("filter by name...");
		nameFilterText.setValueChangeMode(ValueChangeMode.LAZY);

        Button clearNameFilterTextBtn = new Button(VaadinIcons.CLOSE);
        clearNameFilterTextBtn.setDescription("Clear the current filter");     

        CssLayout nameFilter = new CssLayout();
        filtering.addComponents(nameFilterText, clearNameFilterTextBtn);
        filtering.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        
        
        firstnameFilterText.setPlaceholder("filter by firstname...");
        firstnameFilterText.setValueChangeMode(ValueChangeMode.LAZY);

        Button clearFirstnameFilterTextBtn = new Button(VaadinIcons.CLOSE);
        clearFirstnameFilterTextBtn.setDescription("Clear the current filter");    

        CssLayout firstnameFilter = new CssLayout();
        filtering.addComponents(firstnameFilterText, clearFirstnameFilterTextBtn);
        filtering.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        
        
        streetFilterText.setPlaceholder("filter by street...");       
        streetFilterText.setValueChangeMode(ValueChangeMode.LAZY);

        Button clearStreetFilterTextBtn = new Button(VaadinIcons.CLOSE);
        clearStreetFilterTextBtn.setDescription("Clear the current filter");      

        CssLayout streetFilter = new CssLayout();
        filtering.addComponents(streetFilterText, clearStreetFilterTextBtn);
        filtering.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        
        cityFilterText.setPlaceholder("filter by city...");      
        cityFilterText.setValueChangeMode(ValueChangeMode.LAZY);

        Button clearCityFilterTextBtn = new Button(VaadinIcons.CLOSE);
        clearCityFilterTextBtn.setDescription("Clear the current filter");       

        CssLayout cityFilter = new CssLayout();
        filtering.addComponents(streetFilterText, clearCityFilterTextBtn);
        filtering.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
               
        filtering.addComponents(firstnameFilter, nameFilter, streetFilter, cityFilter);
        
        return filtering;
	}
}
