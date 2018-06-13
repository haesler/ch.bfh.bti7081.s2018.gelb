package ch.bfh.bti7081.s2018.yellow.health.ui.components.medication;

import java.sql.Date;
import java.util.List;

import com.vaadin.data.ValueProvider;
import com.vaadin.navigator.View;
import com.vaadin.ui.Grid;

import ch.bfh.bti7081.s2018.yellow.health.models.Medicament;
import ch.bfh.bti7081.s2018.yellow.health.models.Medication;
import ch.bfh.bti7081.s2018.yellow.health.models.Patient;


public interface AddMedicationView extends View{
	
	interface AddMedicationViewListener{
		void buttonClick();
		void filter1(String value, ValueProvider<Medicament, ?> valueProvider);
		boolean checkInput();
	}
	

	public void addListener(AddMedicationViewListener listener);
	public void showMedicaments(List<Medicament> medicament);
	public AddMedicationPresenter getPresenter();
	void setNotification(Boolean value);
	void buttonClick();
	String getUsage();
	Date getStartDate();
	Date getEndDate();
	byte getActive();
	Grid getGrid();
	
	
}
