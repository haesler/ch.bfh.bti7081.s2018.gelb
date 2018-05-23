package ch.bfh.bti7081.s2018.yellow.health.ui.components.searchcontact;


import java.util.List;
import org.springframework.stereotype.Component;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import ch.bfh.bti7081.s2018.yellow.health.models.Contact;
import ch.bfh.bti7081.s2018.yellow.health.repo.ContactRepository;

@Component
public class SearchContactModel {

	
	public ContactRepository repo;
	List<Contact> contacts;
	ListDataProvider<Contact> dataProvider;
	
	public SearchContactModel(ContactRepository repo){
		this.repo =repo;
		contacts = repo.findAll();
		dataProvider =  DataProvider.ofCollection(contacts);
	}

}
