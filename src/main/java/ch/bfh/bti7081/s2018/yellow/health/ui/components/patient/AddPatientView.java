package ch.bfh.bti7081.s2018.yellow.health.ui.components.patient;

import java.sql.Date;
import java.time.LocalDate;

import com.vaadin.navigator.View;

public interface AddPatientView extends View{
	
	interface AddPatientViewListener{
		void buttonClick();
	}
	
	public void addListener(AddPatientViewListener listener);
	void setNotification();
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
