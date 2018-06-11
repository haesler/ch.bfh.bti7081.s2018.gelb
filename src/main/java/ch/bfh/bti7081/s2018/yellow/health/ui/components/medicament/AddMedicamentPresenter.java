package ch.bfh.bti7081.s2018.yellow.health.ui.components.medicament;

import com.vaadin.data.ValueProvider;
import ch.bfh.bti7081.s2018.yellow.health.models.Medicament;

/**
 * This class acts upon the model and the view. It retrieves 
 * data from repositories (the model), and formats it for display in the view.
 * 
 * @author vonak1
 */
public class AddMedicamentPresenter implements AddMedicamentView.AddMedicamentViewListener {

	private AddMedicamentStatus status;
	private AddMedicamentLayoutManager layoutManager;
	private AddMedicamentViewImpl view;
	private AddMedicamentModel model;
	private Medicament medicament = new Medicament();
	
	/**
	* Creates a new <code>AddMedicamentPresenter</code> instance 
	* 
	* @param model	The logic of the view 
	* @param view	A interface that displays data (the model)
	*/
	public AddMedicamentPresenter(AddMedicamentModel model, AddMedicamentViewImpl view) {
		
		this.view = view;
		this.model = model;
		
		view.addListener(this);
		view.grid.setDataProvider(model.dataProvider);
		
		layoutManager = new AddMedicamentLayoutManager(this.view);
		setStatus(AddMedicamentStatus.UNSELECTED);
	}
	
	/**
	* This method is fired when someone clicks a line on the grid
	* 
	* @param selectedMedicament	The medicament that has been choosen
	*/
	@Override
	public void itemClick(Medicament selectedMedicament) {
		medicament = selectedMedicament;
		view.setMedicament(medicament);
		setStatus(AddMedicamentStatus.EDIT);
	}

	/**
	* This method is fired when someone clicks a button
	* 
	* @param buttonName	The name of the button that has been clicked
	*/
	@Override
	public void buttonClick(String buttonName) {
		switch (buttonName) {
        case "Save":
        	saveMedicament(medicament);
    		break;
        case "Delete":
            deleteMedicament(medicament);
            break;
        case "Cancel":
        	setStatus(AddMedicamentStatus.UNSELECTED);
            break;
        case "New":
        	newMedicament();
        	break;
        }	
	}
	
	/**
	* This method is fired when someone types in a character in a filter field of the grid
	* 
	* @param text The value that has been entered
	* @param valueProvider Value provider that gets the property value
	*/
	@Override
	public void filter(String text, ValueProvider<Medicament, ?> valueProvider) {
		if (text != null) {
			model.dataProvider.setFilter(valueProvider, s -> caseInsensitiveContains(s.toString(), text));
		} else {
			model.dataProvider.clearFilters();
		}
        setStatus(AddMedicamentStatus.UNSELECTED);
	}
	
	/**
	* This method is fired when someone clicks on the name or the description field
	* of the medicament. It makes the look of the layout different
	*/
	@Override
	public void changeToModifyMode() {
		setStatus(AddMedicamentStatus.MODIFIED);
	}

	/**
	* A method to check if a string contains another string
	* 
	* @param where		
	* @param what	
	* @return		true - if where is in what
	* 				false - if where is not in what
	*/
	private Boolean caseInsensitiveContains(String where, String what) {
		return where.toLowerCase().contains(what.toLowerCase());
	}

	/*private boolean checkInput(){
		if(view.getMedicamentName() == "" || view.getMedicamentName() == null){
			return false;
		}
		return true;
	}*/
	
	/**
	* This method creates a new instance of a medicament and displays it
	*/
	private void newMedicament() {
		medicament = new Medicament();
		medicament.createMedicament();
		view.setMedicament(medicament);
		setStatus(AddMedicamentStatus.NEW);
	}

	/**
	* This method deletes a medicament from the database
	* 
	* @param medicament	The medicament to delete
	*/
	private void deleteMedicament(Medicament medicament) {
		model.delete(medicament);
		updateGrid();	
		setStatus(AddMedicamentStatus.UNSELECTED);
	}

	/**
	* This method saves a medicament to the database
	* 
	* @param medicament	The medicament to save
	*/
	private void saveMedicament(Medicament medicament) {
		if (view.getMedicamentName().isEmpty()) {
			view.setNotification("Name cannot be empty");
			return;
		}
		medicament.setInfo(view.getMedicamentName(),view.getMedicamentDescription());
		model.save(medicament);
		updateGrid();
		setStatus(AddMedicamentStatus.UNSELECTED);
	}

	/**
	* This method is fired after changes are made to the database.
	* It retrieves/provides the current data.
	*/
	private void updateGrid() {
		model.refresh();
        view.grid.setDataProvider(model.dataProvider);	
	}
	
	/**
	* This method is fired when the layout need to be changed. The layoutmanager
	* processes the change. The status are defined as Enum (AddMedicamentStatus)
	* 
	* @param status	The new status (unselected, new, edit, modified) of the layout
	*/
	private void setStatus(AddMedicamentStatus status) {
		this.status = status;
		layoutManager.setLayout(status);	
	}
}
