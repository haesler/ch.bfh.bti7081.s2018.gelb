package ch.bfh.bti7081.s2018.yellow.health.ui.components.medicament;

import ch.bfh.bti7081.s2018.yellow.health.models.Medicament;
import ch.bfh.bti7081.s2018.yellow.health.repo.MedicamentRepository;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.searchcontact.SearchContactModel;

public class AddMedicamentPresenter implements AddMedicamentView.AddMedicamentViewListener{
	
	AddMedicamentViewImpl view;
	AddMedicamentModel model;
	//MedicamentRepository medicamentRepository;
	Medicament medicament = new Medicament();
	
	
	public AddMedicamentPresenter(AddMedicamentModel model, AddMedicamentViewImpl view){
		this.view = view;
		this.model = model;
		
		view.showMedicaments(model.medicaments);
		view.addListener(this);
		view.getGrid().setDataProvider(model.dataProvider);
	}
	
	public void buttonClick() {
		
		medicament.createMedicament(view.getMedicamentName(), view.getMedicamentDescription());
		model.repo.save(medicament);
		model.dataProvider.refreshAll();
		
	}
	
}
