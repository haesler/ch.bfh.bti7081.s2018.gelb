package ch.bfh.bti7081.s2018.yellow.health.ui.components.medicament;

/**
 * This class changes the layout of the provided view.
 * 
 * @author vonak1
 */
public class AddMedicamentLayoutManager {

	private AddMedicamentViewImpl view;
	
	/**
	* Creates a new <code>AddMedicamentLayoutManager</code> instance 
	* 
	* @param view	The view which layout needs to be changed 
	*/
	public AddMedicamentLayoutManager(AddMedicamentViewImpl view) {
		this.view = view;
	}
	
	/**
	* This method calls the right method for the given status
	* 
	* @param status A status in which the view has to be set
	*/
	public void setLayout(AddMedicamentStatus status) {
		
		switch (status) {
        case UNSELECTED:
        	setSelectedLayout(false);
    		break;
        case EDIT:
        	setSelectedLayout(true);
            break;
        case MODIFIED:
        	setModifiedLayout();
            break;
        case NEW:
        	setNewLayout();
        	break;
        }	
	}
	
	/**
	* This method sets the view in the selected- or unselected-mode
	* 
	* @param visible	Sets components visible/enabled or not
	*/
	private void setSelectedLayout(boolean visible) {
		if (!visible) {
			view.grid.deselectAll();
			view.getNewButton().setEnabled(true);
		}
		view.grid.setEnabled(true);
		view.getDeleteButton().setEnabled(true);
		view.getFlEdit().setVisible(visible);
		view.getCancelButton().setVisible(visible);
		view.getDeleteButton().setVisible(visible);
		view.getSaveButton().setVisible(visible);
		view.getSaveButton().setEnabled(false);
		view.setNotification("");
	}
	
	/**
	* This method sets the view in the new-mode
	*/
	private void setNewLayout() {
		view.grid.deselectAll();
		view.grid.setEnabled(false);
		view.getNewButton().setEnabled(false);
		view.getDeleteButton().setEnabled(false);
		view.getFlEdit().setVisible(true);
		view.getCancelButton().setVisible(true);
		view.getSaveButton().setVisible(true);
		view.getSaveButton().setEnabled(true);
		view.setNotification("");
	}
	
	/**
	* This method sets the view in the modified-mode
	*/
	private void setModifiedLayout() {
		view.grid.setEnabled(false);
		view.getNewButton().setEnabled(false);
		view.getDeleteButton().setEnabled(false);
		view.getSaveButton().setEnabled(true);
	}
}
