package ch.bfh.bti7081.s2018.yellow.health.ui.components.searchMedication;

import java.util.List;

import com.vaadin.data.ValueProvider;
import com.vaadin.navigator.View;

import ch.bfh.bti7081.s2018.yellow.health.models.Medication;

public interface SearchMedicationView extends View {
	
	interface SearchMedicationViewListener {
        void filter1(String value, ValueProvider<Medication, ?> valueProvider);
        void editMedication(Medication medication);
    	void addMedicationClicked();
    }
	
	public void addListener(SearchMedicationViewListener listener);
	
	public void showMedication(List<Medication> medications);
	void addMedicationClicked();
	
}
