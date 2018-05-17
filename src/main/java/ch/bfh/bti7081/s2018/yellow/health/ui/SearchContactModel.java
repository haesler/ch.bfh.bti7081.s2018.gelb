package ch.bfh.bti7081.s2018.yellow.health.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.init.RepositoriesPopulatedEvent;

import com.vaadin.data.Binder;
import com.vaadin.ui.Grid;

import ch.bfh.bti7081.s2018.yellow.health.models.Contact;
import ch.bfh.bti7081.s2018.yellow.health.repo.ContactRepository;

public class SearchContactModel {

	@Autowired
	ContactRepository repo;

	List<Contact> contacts;
	
	private Binder<Contact> binder = new Binder<>(Contact.class);
	
	public SearchContactModel(){
		contacts = repo.findAll();
	}
	
	public List<Contact> findLastname(String searchString){
		contacts = repo.findByLastname(searchString);
		return contacts;
	}
	
	public List<Contact> findFirstname(String searchString){
		contacts = repo.findByFirstname(searchString);
		return contacts;
	}
	
	public List<Contact> findStreet(String searchString){
		contacts = repo.findByStreet(searchString);
		return contacts;
	}
	
	public List<Contact> findCity(String searchString){
		contacts = repo.findByCity(searchString);
		return contacts;
	}
}
