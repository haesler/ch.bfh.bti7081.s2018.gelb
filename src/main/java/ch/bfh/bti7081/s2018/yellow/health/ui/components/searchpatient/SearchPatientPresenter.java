package ch.bfh.bti7081.s2018.yellow.health.ui.components.searchpatient;

import org.springframework.stereotype.Component;

import com.vaadin.data.ValueProvider;

import ch.bfh.bti7081.s2018.yellow.health.models.Patient;

public class SearchPatientPresenter implements SearchPatientView.SearchPatientViewListener{

	SearchPatientModel model;
	SearchPatientViewImpl view;
	
	
	public SearchPatientPresenter(SearchPatientModel model,SearchPatientViewImpl view) {
		this.model = model;
		this.view  = view;

		view.showPatients(model.patients);
		view.addListener(this);
		view.grid.setDataProvider(model.dataProvider);
	}
	
	
	public void filter1(String text, ValueProvider<Patient, ?> valueProvider) {
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
