package ch.bfh.bti7081.s2018.yellow.health.ui.components.contact;

import java.sql.Date;

import com.vaadin.navigator.View;

import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.AddContactLayout;
import ch.bfh.bti7081.s2018.yellow.health.models.Contact;

public interface AddContactView extends View{
	
	interface AddContactViewListener{
		public void buttonClick();
		public void loadContact(Contact contact);
	}
	
	public void addListener(AddContactViewListener listener);
	void setNotification(Boolean value);
	void buttonClick();
	String getName();
	String getFirstName();
	String getStreet();
	String getPLZ();
	String getCity();
	String getPhone();
	String getMobile();
	String getMail();
	Date getBirthday();
	AddContactLayout getLayout();
	void setName(String name);
	void setFirstName(String firstname);
	void setStreet(String street);
	void setPLZ(String plz);
	void setCity(String city);
	void setPhone(String phone);
	void setMobile(String mobile);
	void setMail(String mail);
	void setBirthday(Date birthday);
}
