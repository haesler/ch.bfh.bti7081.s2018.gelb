package ch.bfh.bti7081.s2018.yellow.health.ui.components.medicament;

import com.vaadin.ui.Notification;

import ch.bfh.bti7081.s2018.yellow.health.models.Medicament;
import ch.bfh.bti7081.s2018.yellow.health.repo.MedicamentRepository;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.searchcontact.SearchContactModel;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.validate.MedicamentValidate;

public class AddMedicamentPresenter implements AddMedicamentView.AddMedicamentViewListener{
	
	//AddMedicamentViewImpl view;
	AddMedicamentView view;
	AddMedicamentModel model;
	MedicamentValidate validateMedicament;
	//MedicamentRepository medicamentRepository;
	Medicament medicament = new Medicament();
	
	
	public AddMedicamentPresenter(AddMedicamentModel model, AddMedicamentViewImpl view){
		this.view = view;
		this.model = model;
		validateMedicament = new MedicamentValidate();
		view.showMedicaments(model.medicaments);
		view.addListener(this);
		view.getGrid().setDataProvider(model.dataProvider);
	}
	
	public void buttonClick() {
		
		if(
				validateMedicament.isValid(view.getLayout().getTxt_Name(), view.getLayout().getTxt_Description())
		){
			medicament.createMedicament(view.getMedicamentName(), view.getMedicamentDescription());
			model.repo.save(medicament);
			model.dataProvider.refreshAll();
			Notification.show("Medicament successfully saved");
		}
		
	}
	
}
