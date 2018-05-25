package ch.bfh.bti7081.s2018.yellow.health.ui.components.patient;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.bti7081.s2018.yellow.health.models.Patient;

public interface PatientView extends View {
	
	interface PatientViewListener {
        void buttonClick(String buttonName);
        void valueChange(String txtFieldName, String value);
    }
	
	public void addListener(PatientViewListener listener);
	
	public void setPatient(Patient patient);
	
	public void clearText(TextField txtField);

	public VerticalLayout filterInit();
}
