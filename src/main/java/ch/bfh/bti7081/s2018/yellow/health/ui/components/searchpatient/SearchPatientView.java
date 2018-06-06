package ch.bfh.bti7081.s2018.yellow.health.ui.components.searchpatient;

import java.util.List;

import com.vaadin.data.ValueProvider;
import com.vaadin.navigator.View;

import ch.bfh.bti7081.s2018.yellow.health.models.Contact;
import ch.bfh.bti7081.s2018.yellow.health.models.Patient;

public interface SearchPatientView extends View {
	
	interface SearchPatientViewListener {
        void filter1(String value, ValueProvider<Patient, ?> valueProvider);
        void editPatient(Patient patient);
    }
	
	public void addListener(SearchPatientViewListener listener);
	
	public void showPatients(List<Patient> patient);
	
}
