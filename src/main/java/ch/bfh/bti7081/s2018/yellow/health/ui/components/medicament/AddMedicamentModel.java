package ch.bfh.bti7081.s2018.yellow.health.ui.components.medicament;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;

import ch.bfh.bti7081.s2018.yellow.health.models.Medicament;
import ch.bfh.bti7081.s2018.yellow.health.repo.MedicamentRepository;

/**
* This class is an interface defining the data to be displayed 
* or otherwise acted upon in the user interface.
* 
* @author vonak1
*/
@Service
public class AddMedicamentModel {

	public MedicamentRepository repo;
	public ListDataProvider<Medicament> dataProvider;
	public List<Medicament> medicaments;
	
	/**
	* Creates a new <code>AddMedicamentModel</code> instance 
	* 
	* @param repo	A repository that provides the entries of the database 
	*/
	@Autowired
	public AddMedicamentModel(MedicamentRepository repo){
		this.repo = repo;
		refresh();
	}
	
	/**
	* This method retrieves the data from the medicament table 
	*/
	public void refresh() {
		medicaments = repo.findAll();
		dataProvider = DataProvider.ofCollection(medicaments);
		dataProvider.refreshAll();
	}
	
	/**
	* This method deletes a entry from the database
	* 
	* @param The medicament to delete
	*/
	public void delete(Medicament medicament) {
		repo.delete(medicament);
	}
	
	/**
	* This method saves a entry to the database
	* 
	* @param The medicament to save
	*/
	public void save(Medicament medicament) {
		repo.save(medicament);
	}
}
