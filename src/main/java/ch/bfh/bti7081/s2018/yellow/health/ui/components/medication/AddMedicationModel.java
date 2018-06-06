package ch.bfh.bti7081.s2018.yellow.health.ui.components.medication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;

import ch.bfh.bti7081.s2018.yellow.health.models.Medication;
import ch.bfh.bti7081.s2018.yellow.health.repo.MedicationRepository;

@Service
public class AddMedicationModel {
	
	public MedicationRepository repo;
	public List<Medication> medication;
	public ListDataProvider<Medication> dataProvider;

	@Autowired
	public AddMedicationModel(MedicationRepository repo){
		this.repo =repo;
		medication = repo.findAll();
		dataProvider =  DataProvider.ofCollection(medication);
	}
}
