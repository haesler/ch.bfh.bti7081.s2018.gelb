package ch.bfh.bti7081.s2018.yellow.health.ui.components.searchhistory;

import org.springframework.stereotype.Component;

import com.vaadin.data.ValueProvider;
import com.vaadin.ui.UI;

import ch.bfh.bti7081.s2018.yellow.health.models.Contact;
import ch.bfh.bti7081.s2018.yellow.health.models.Historyentry;
import ch.bfh.bti7081.s2018.yellow.health.models.Patient;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.contact.AddContactViewImpl;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.patient.AddPatientViewImpl;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.tabcontrol.Tabpage;

public class SearchHistoryPresenter implements Tabpage{

	SearchHistoryModel model;
	SearchHistoryViewImpl view;
	
	
	public SearchHistoryPresenter(SearchHistoryModel model,SearchHistoryViewImpl view) {
		this.model = model;
		this.view  = view;
	}
	

@Override
public void setPatient(Patient patient) {
	// TODO Auto-generated method stub
	
}

@Override
public void loadPatient() {
	// TODO Auto-generated method stub
	
}

@Override
public boolean checkInput() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public Patient save() {
	// TODO Auto-generated method stub
	return null;
}


}
