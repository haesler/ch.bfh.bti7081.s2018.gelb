package ch.bfh.bti7081.s2018.yellow.health.ui.components.searchhistory;

import org.springframework.stereotype.Component;

import com.vaadin.data.ValueProvider;
import com.vaadin.ui.UI;

import ch.bfh.bti7081.s2018.yellow.health.models.Contact;
import ch.bfh.bti7081.s2018.yellow.health.models.History;
import ch.bfh.bti7081.s2018.yellow.health.models.Historyentry;
import ch.bfh.bti7081.s2018.yellow.health.models.Medication;
import ch.bfh.bti7081.s2018.yellow.health.models.Patient;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.contact.AddContactViewImpl;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.patient.AddPatientViewImpl;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.searchhistory.SearchHistoryView.SearchHistoryViewListener;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.tabcontrol.Tabpage;

public class SearchHistoryPresenter implements SearchHistoryViewListener, Tabpage{

	SearchHistoryModel model;
	SearchHistoryViewImpl view;
	
	
	public SearchHistoryPresenter(SearchHistoryModel model,SearchHistoryViewImpl view) {
		this.model = model;
		this.view  = view;
		
		view.showEntrys(model.entrys);
		view.addListener(this);
		view.grid.setDataProvider(model.dataProvider);
	}
	

@Override
public void setPatient(Patient patient) {
	model.findByPatient(patient.getPatientID());
	System.out.println(model.dataProvider.toString());
	view.grid.getDataProvider().refreshAll();
	
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


@Override
public void filter1(String text, ValueProvider<History, ?> valueProvider) {
	if (text != null) {
		model.dataProvider.setFilter(valueProvider, s -> caseInsensitiveContains(s.toString(), text));
	  } else {
		  model.dataProvider.clearFilters();
	  }
}


private Boolean caseInsensitiveContains(String where, String what) {
    return where.toLowerCase().contains(what.toLowerCase());
}




}
