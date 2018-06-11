package ch.bfh.bti7081.s2018.yellow.health.ui.components.medicament;

/**
 * These are the different states which can occur in the process
 * of adding a new medicament
 * 
 * @author vonak1
 */
public enum AddMedicamentStatus {
	
	/**
	 * Status when a new medicament is created and 
	 * not saved to the database
	 */
	NEW, 
	
	/**
	 * Status when a medicament is selected but
	 * not edited. The current values are the same
	 * as in the database
	 */
	EDIT, 
	
	/**
	 * Status when a new medicament has been edited.
	 * The current values are not the same
	 * as in the database
	 */
	MODIFIED, 
	
	/**
	 * Status when no medicament is selected
	 */
	UNSELECTED;
}
