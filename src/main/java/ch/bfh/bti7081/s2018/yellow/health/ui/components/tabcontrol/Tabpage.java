package ch.bfh.bti7081.s2018.yellow.health.ui.components.tabcontrol;

import ch.bfh.bti7081.s2018.yellow.health.models.Patient;

public interface Tabpage {
	public void setPatient(Patient patient);
	public void loadPatient();
	public boolean checkInput();
	
	public Patient save();
	
}
