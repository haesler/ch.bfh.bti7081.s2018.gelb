package ch.bfh.bti7081.s2018.yellow.health.ui.components.medicament;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;

import ch.bfh.bti7081.s2018.yellow.health.models.Medicament;
import ch.bfh.bti7081.s2018.yellow.health.repo.MedicamentRepository;

@Service
public class AddMedicamentModel {

	public MedicamentRepository repo;
	public List<Medicament> medicaments;
	public ListDataProvider<Medicament> dataProvider;
	
	@Autowired
	public AddMedicamentModel(MedicamentRepository repo){
		this.repo =repo;
		medicaments = repo.findAll();
		dataProvider =  DataProvider.ofCollection(medicaments);
	}
}
