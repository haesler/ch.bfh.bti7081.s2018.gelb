package ch.bfh.bti7081.s2018.yellow.health.ui.components.searchcontact;

import java.util.List;

import com.vaadin.data.ValueProvider;


import ch.bfh.bti7081.s2018.yellow.health.models.Contact;

public interface SearchContactView {
	
	interface SearchContactViewListener {
        void filter1(String value, ValueProvider<Contact, ?> valueProvider);
    }
	
	public void addListener(SearchContactViewListener listener);
	
	public void showContacts(List<Contact> contacts);
	
}
