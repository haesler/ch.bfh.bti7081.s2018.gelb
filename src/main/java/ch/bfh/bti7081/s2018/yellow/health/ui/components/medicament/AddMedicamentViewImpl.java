package ch.bfh.bti7081.s2018.yellow.health.ui.components.medicament;

import java.awt.Event;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaadin.data.ValueProvider;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.TextField;
import com.vaadin.ui.components.grid.HeaderCell;
import com.vaadin.ui.components.grid.HeaderRow;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.s2018.yellow.health.models.Medicament;
import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.AddMedicamentLayout;

/**
* This class is a passive interface that displays data (the model) 
* and routes user commands (events) to the presenter to act upon that data.
* 
* @author vonak1
*/
@Component
public class AddMedicamentViewImpl extends AbsoluteLayout implements AddMedicamentView {

	private static final long serialVersionUID = 1L;
	
	List<AddMedicamentViewListener> listeners = new ArrayList<AddMedicamentViewListener>();
	private AddMedicamentPresenter presenter;
	private AddMedicamentLayout layout;
	
	public Grid<Medicament> grid;
	Medicament selectedMedicament;

	/**
	* Creates a new <code>AddMedicamentViewImpl</code> instance 
	* 
	* @param model	The logic of the view 
	*/
	@Autowired
	public AddMedicamentViewImpl(AddMedicamentModel model){
		
		//get the layout, which was created by vaadin-designer
		layout = new AddMedicamentLayout();
		
        grid = getGrid();      
        addAllListener();
        
        addGridFilter();
        addComponent(layout);
		
        //create a new presenter, that connects the model and the view
		this.presenter = new AddMedicamentPresenter(model,this);
	}
	
	/**
	* This method sets up all the needed listeners  
	*/
	private void addAllListener() {
		getSaveButton().addClickListener(event -> this.buttonClick(event));
		getDeleteButton().addClickListener(event -> this.buttonClick(event));
		getCancelButton().addClickListener(event -> this.buttonClick(event));
		getNewButton().addClickListener(event -> this.buttonClick(event));
			
		getNameTxtField().addFocusListener(event -> this.txtFieldFocus());
		getDescriptionTxtField().addFocusListener(event -> this.txtFieldFocus());
		
		grid.addItemClickListener(event -> this.showMedicament(event.getItem()));
	}

	/**
	* This method adds a new filter row in the header of the grid 
	*/
	private void addGridFilter() {
		setSizeFull();
   
		// Create a header row to hold column filters
		HeaderRow filterRow = grid.appendHeaderRow();
		
		// Set up a filter for all columns
		for (Column<Medicament, ?> pid: grid.getColumns()) {
		    HeaderCell cell = filterRow.getCell(pid.getId());
		    final TextField filter = new TextField();
		    filter.setPlaceholder("Filter");
		    filter.addValueChangeListener(event -> {refresh(filter.getValue(),  pid.getValueProvider());});
		    filter.addStyleName(ValoTheme.TEXTFIELD_TINY);
		    cell.setComponent(filter);
		}
		//only 1 line can be selected in the grid
		grid.setSelectionMode(SelectionMode.SINGLE);
	}
	
	/**
	* This method is fired when someone types in a character in a filter field of the grid
	* 
	* @param text The value that has been entered
	* @param valueProvider Value provider that gets the property value
	*/
	private void refresh(String text, ValueProvider<Medicament, ?> valueProvider) {	
		for (AddMedicamentViewListener listener: listeners)
			listener.filter(text, valueProvider);
    }
	
	/**
	* This method is fired when someone clicks a line on the grid
	* 
	* @param selectedMedicament	The medicament that has been choosen
	*/
	private void showMedicament(Medicament selectedMedicament) {
		for (AddMedicamentViewListener listener: listeners)
			listener.itemClick(selectedMedicament);
	}

	/**
	* This method is fired when someone clicks a button
	* 
	* @param event	The event that has been fired
	*/
	public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
		for (AddMedicamentViewListener listener: listeners)
			listener.buttonClick(event.getButton().getCaption());
	}
	
	/**
	* This method is fired when someone clicks on the name or the description field
	* of the medicament. It makes the look of the layout different
	*/
	private void txtFieldFocus() {
		for (AddMedicamentViewListener listener: listeners)
			listener.changeToModifyMode();
	}
	
	/**
	* Adds the presenter as a listener to the view
	* 
	* @param listener	A instance of the AddMedicamentPresenter-Class
	*/
	@Override
	public void addListener(AddMedicamentViewListener listener) {
		listeners.add(listener);
	}
	
	/**
	* Sets the values (name, description) of a medicament in the edit
	* fields 
	* 
	* @param medicament	The medicament that has to be displayed
	*/
	public void setMedicament(Medicament medicament) {
		layout.getTxt_Name().setValue(medicament.getName());
		layout.getTxt_Description().setValue(medicament.getDescription());
	}

	/**
	* A method that displays a notification 
	* 
	* @param message	A message that has to be displayed
	*/
	public void setNotification(String message){
		if(message.isEmpty()) {
			layout.getLbl_Message().setVisible(false);
			return;
		}
		layout.getLbl_Message().setValue(message);
		layout.getLbl_Message().setVisible(true);
	}

	public String getMedicamentName() {
		return layout.getTxt_Name().getValue();
	}

	public String getMedicamentDescription() {
		return layout.getTxt_Description().getValue();
	}
	
	public Grid<Medicament> getGrid() {
		return layout.getGr_Medicaments();
	}
	
	public Button getSaveButton() {
		return layout.getBu_save();
	}
	
	public Button getDeleteButton() {
		return layout.getBu_delete();
	}
	
	public Button getCancelButton() {
		return layout.getBu_cancel();
	}
	
	public Button getNewButton() {
		return layout.getBu_new();
	}
	
	public FormLayout getFlEdit() {
		return layout.getFl_edit();
	}
	
	public TextField getNameTxtField() {
		return layout.getTxt_Name();
	}
	
	public TextField getDescriptionTxtField() {
		return layout.getTxt_Name();
	}
}
