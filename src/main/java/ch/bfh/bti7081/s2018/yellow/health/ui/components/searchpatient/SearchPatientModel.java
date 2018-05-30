package ch.bfh.bti7081.s2018.yellow.health.ui.components.searchpatient;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import ch.bfh.bti7081.s2018.yellow.health.models.Patient;
import ch.bfh.bti7081.s2018.yellow.health.repo.PatientRepository;

@Service
public class SearchPatientModel {

	
	public PatientRepository repo;
	List<Patient> patients;
	ListDataProvider<Patient> dataProvider;
	
	@Autowired
	public SearchPatientModel(PatientRepository repo){
		this.repo =repo;
		patients = repo.findAll();
		dataProvider =  DataProvider.ofCollection(patients);
	}

}
