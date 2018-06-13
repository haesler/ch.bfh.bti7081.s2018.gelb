package ch.bfh.bti7081.s2018.yellow.health.ui.components.searchcontact;

import java.util.List;

import com.vaadin.data.ValueProvider;
import com.vaadin.navigator.View;

import ch.bfh.bti7081.s2018.yellow.health.models.Contact;

public interface SearchContactView extends View {
	
	interface SearchContactViewListener {
        void filter1(String value, ValueProvider<Contact, ?> valueProvider);
        void editContact(Contact contact);
    	void addContactClicked();
    }
	
	public void addListener(SearchContactViewListener listener);
	
	public void showContacts(List<Contact> contacts);
	void addContactClicked();
	
}
