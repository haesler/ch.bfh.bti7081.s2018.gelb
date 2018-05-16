package ch.bfh.bti7081.s2018.yellow.health.ui;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.bti7081.s2018.yellow.health.models.Contact;

public interface SearchContactView extends View{
	
	interface SearchContactViewListener {
        void buttonClick(String buttonName);
        void valueChange(String txtFieldName, String value);
    }
	
	public void addListener(SearchContactViewListener listener);
	
	public void showContacts(List<Contact> contacts);
	
	public void clearText(TextField txtField);

	public VerticalLayout filterInit();
}
