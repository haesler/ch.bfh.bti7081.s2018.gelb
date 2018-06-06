package ch.bfh.bti7081.s2018.yellow.health.ui.components.medication;

import java.sql.Date;
import java.util.List;

import com.vaadin.data.ValueProvider;
import com.vaadin.navigator.View;
import com.vaadin.ui.Grid;

import ch.bfh.bti7081.s2018.yellow.health.models.Medication;


public interface AddMedicationView extends View{
	
	interface AddMedicationViewListener{
		void buttonClick();
		void filter1(String value, ValueProvider<Medication, ?> valueProvider);
	}
	

	public void addListener(AddMedicationViewListener listener);
	public void showMedications(List<Medication> medications);
	void setNotification(Boolean value);
	void buttonClick();
	String getUsage();
	Date getStartDate();
	Date getEndDate();
	byte getActive();
	Grid getGrid();
	
	
}
