package ch.bfh.bti7081.s2018.yellow.health.ui.components.searchMedication;

import com.vaadin.data.ValueProvider;
import ch.bfh.bti7081.s2018.yellow.health.models.Medication;
import ch.bfh.bti7081.s2018.yellow.health.models.Patient;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.searchMedication.SearchMedicationView.SearchMedicationViewListener;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.tabcontrol.Tabpage;

public class SearchMedicationPresenter implements SearchMedicationViewListener, Tabpage{

	SearchMedicationModel model;
	SearchMedicationvVewImpl view;
	
	
	public SearchMedicationPresenter(SearchMedicationModel model,SearchMedicationvVewImpl view) {
		this.model = model;
		this.view  = view;

		view.showMedication(model.medications);
		view.addListener(this);
		view.grid.setDataProvider(model.dataProvider);
	}
	
	
	public void filter1(String text, ValueProvider<Medication, ?> valueProvider) {
		if (text != null) {
			model.dataProvider.setFilter(valueProvider, s -> caseInsensitiveContains(s.toString(), text));
    	  } else {
    		  model.dataProvider.clearFilters();
    	  }
	}
	
	
   private Boolean caseInsensitiveContains(String where, String what) {
        return where.toLowerCase().contains(what.toLowerCase());
    }


	@Override
	public void editMedication(Medication medication) {
		//UI.getCurrent().getNavigator().navigateTo("EditContact");
		//((AddContactViewImpl)UI.getCurrent().getNavigator().getCurrentView()).getPresenter().loadContact(contact);
	}
	
	
	@Override
	public void addMedicationClicked() {
		//UI.getCurrent().getNavigator().navigateTo("AddContact");
		//((AddContactViewImpl)UI.getCurrent().getNavigator().getCurrentView()).getPresenter().loadContact(new Contact());	
		
	}


	@Override
	public void setPatient(Patient patient) {
		//filter1(Integer.toString(patient.getPatientID()), view.grid.getColumn("PatientID").getValueProvider());
		//model.findByPatient(patient.getPatientID());
		//System.out.println(model.dataProvider.toString());
		
		//view.grid.getDataProvider().refreshAll();
		
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
