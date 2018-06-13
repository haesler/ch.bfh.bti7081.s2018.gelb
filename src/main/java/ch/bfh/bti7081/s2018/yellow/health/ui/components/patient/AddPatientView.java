package ch.bfh.bti7081.s2018.yellow.health.ui.components.patient;

import java.sql.Date;
import java.time.LocalDate;

import com.vaadin.navigator.View;
import com.vaadin.ui.DateField;
import com.vaadin.ui.TextField;

import ch.bfh.bti7081.s2018.yellow.health.models.Doctor;
import ch.bfh.bti7081.s2018.yellow.health.models.Insurance;
import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.AddPatientLayout;

public interface AddPatientView extends View{
	
	interface AddPatientViewListener{
		void buttonClick();
	}
	
	public void addListener(AddPatientViewListener listener);
	AddPatientPresenter getPresenter();
	void setNotification();
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
	void setName(String name);
	void setFirstName(String firstname);
	void setStreet(String street);
	void setPLZ(String plz);
	void setCity(String city);
	void setPhone(String phone);
	void setMobile(String mobile);
	void setMail(String mail);
	void setStartdate(LocalDate start);
	void setEnddate(LocalDate end);
	void setInsurance(Insurance i);
	void setDoctor(Doctor d);
	void setBirthday(LocalDate date);
	boolean check();
	Date getStartdate();
	Date getEnddate();
	AddPatientLayout getLayout();
	
	Insurance getInsurance();
	Doctor getDoctor();
	
}
