package ch.bfh.bti7081.s2018.yellow.health.ui.components.searchMedication;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import ch.bfh.bti7081.s2018.yellow.health.models.Medication;
import ch.bfh.bti7081.s2018.yellow.health.repo.MedicationRepository;

@Service
public class SearchMedicationModel {

	
	public MedicationRepository repo;
	List<Medication> medications;
	ListDataProvider<Medication> dataProvider;
	
	@Autowired
	public SearchMedicationModel(MedicationRepository repo){
		this.repo =repo;
		medications = repo.findPatient();
		dataProvider =  DataProvider.ofCollection(medications);
	}
	
	public void findByPatient(int Patient){
		medications = repo.findbyPatient(Patient);
		dataProvider =  DataProvider.ofCollection(medications);
	}

}
