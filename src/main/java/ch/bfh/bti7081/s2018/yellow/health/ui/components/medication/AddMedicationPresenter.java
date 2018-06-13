package ch.bfh.bti7081.s2018.yellow.health.ui.components.medication;

import com.vaadin.data.ValueProvider;

import ch.bfh.bti7081.s2018.yellow.health.models.Medicament;
import ch.bfh.bti7081.s2018.yellow.health.models.Medication;
import ch.bfh.bti7081.s2018.yellow.health.models.Patient;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.medicament.AddMedicamentModel;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.tabcontrol.Tabpage;

public class AddMedicationPresenter implements AddMedicationView.AddMedicationViewListener, Tabpage {

	private AddMedicationViewImpl view;
	private AddMedicationModel model;
	private AddMedicamentModel modelMeds;
	private Patient patient;
	private Medication medication = new Medication();
	
	public AddMedicationPresenter(AddMedicationModel model, AddMedicamentModel modelMeds, AddMedicationViewImpl view){
		this.view = view;
		this.model = model;
		this.modelMeds = modelMeds;
		
		view.showMedicaments(modelMeds.medicaments);
		view.addListener(this);
		view.getGrid().setDataProvider(modelMeds.dataProvider);
	}
	
	@Override
	public void buttonClick() {
		save();
	}
	@Override
	public void filter1(String text, ValueProvider<Medicament, ?> valueProvider) {
		if (text != null) {
			modelMeds.dataProvider.setFilter(valueProvider, s -> caseInsensitiveContains(s.toString(), text));
    	  } else {
    		  modelMeds.dataProvider.clearFilters();
    	  }
	}
	
	private Boolean caseInsensitiveContains(String where, String what) {
        return where.toLowerCase().contains(what.toLowerCase());
    }



	public void loadPatient() {
		//
		
	}

	@Override
	public void setPatient(Patient patient) {
		this.patient = patient;
		
	}

	@Override
	public Patient save() {
		//get Form-input and save Medication
		if(view.checkInput() == true){
			view.setNotification(false);
			
			//temp Paitent hardcoded, have to get the active patient
			Patient patient = new Patient();
			patient.setPatientID(1);
			medication.createMedication(view.getMedicament(), patient, view.getActive(), view.getEndDate(), view.getStartDate(), view.getUsage());
			model.repo.save(medication);
			model.dataProvider.refreshAll();
		}else{
			view.setNotification(true);
		}
		
		return patient;
	}

	@Override
	public boolean checkInput() {
		return view.checkInput();
	}


}
