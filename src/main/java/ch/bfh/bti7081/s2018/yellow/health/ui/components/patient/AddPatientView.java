package ch.bfh.bti7081.s2018.yellow.health.ui.components.patient;

import java.sql.Date;
import java.time.LocalDate;

import com.vaadin.navigator.View;

import ch.bfh.bti7081.s2018.yellow.health.models.Doctor;
import ch.bfh.bti7081.s2018.yellow.health.models.Insurance;

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
	Integer getPLZ();
	String getCity();
	String getPhone();
	String getMobile();
	String getMail();
	Date getBirthday();
	void setName(String name);
	void setFirstName(String firstname);
	void setStreet(String street);
	void setPLZ(Integer plz);
	void setCity(String city);
	void setPhone(String phone);
	void setMobile(String mobile);
	void setMail(String mail);
	void setStartdate(Date start);
	void setEnddate(Date end);
	void setInsurance(Insurance i);
	void setDoctor(Doctor d);
	void setBirthday(Date date);
	Date getStartdate();
	Date getEnddate();
	Insurance getInsurance();
	Doctor getDoctor();
}
