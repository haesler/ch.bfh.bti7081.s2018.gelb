package ch.bfh.bti7081.s2018.yellow.health.ui.components.contact;

import java.sql.Date;

import com.vaadin.navigator.View;

public interface AddContactView extends View{
	
	interface AddContactViewListener{
		void buttonClick();
	}
	
	public void addListener(AddContactViewListener listener);
	void setNotification(Boolean value);
	void buttonClick();
	String getName();
	String getFirstName();
	String getStreet();
	Integer getPLZ();
	String getCity();
	String getPhone();
	String getMobile();
	String getMail();
	Date getBirthday();
}
