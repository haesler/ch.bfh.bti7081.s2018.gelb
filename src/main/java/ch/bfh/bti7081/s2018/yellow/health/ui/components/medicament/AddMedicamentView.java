package ch.bfh.bti7081.s2018.yellow.health.ui.components.medicament;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;

import ch.bfh.bti7081.s2018.yellow.health.models.Medicament;

public interface AddMedicamentView extends View {
	
	interface AddMedicamentViewListener{
		void buttonClick();
	}
	
	public void addListener(AddMedicamentViewListener listener);
	public void showMedicaments(List<Medicament> medicaments);
	
	void setNotification();
	void buttonClick();
	
	String getMedicamentName();
	String getMedicamentDescription();
	Grid<Medicament> getGrid();
	Button getSaveButton();
}