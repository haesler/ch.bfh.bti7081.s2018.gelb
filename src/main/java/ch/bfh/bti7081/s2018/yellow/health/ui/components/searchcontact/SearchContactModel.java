package ch.bfh.bti7081.s2018.yellow.health.ui.components.searchcontact;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import ch.bfh.bti7081.s2018.yellow.health.models.Contact;
import ch.bfh.bti7081.s2018.yellow.health.repo.ContactRepository;

@Service
public class SearchContactModel {

	
	public ContactRepository repo;
	List<Contact> contacts;
	ListDataProvider<Contact> dataProvider;
	
	@Autowired
	public SearchContactModel(ContactRepository repo){
		this.repo =repo;
		contacts = repo.findAll();
		dataProvider =  DataProvider.ofCollection(contacts);
	}

}
