package ch.bfh.bti7081.s2018.yellow.health.ui.components.patient;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaadin.server.Resource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.NativeSelect;

import ch.bfh.bti7081.s2018.yellow.health.models.Doctor;
import ch.bfh.bti7081.s2018.yellow.health.models.Insurance;
import ch.bfh.bti7081.s2018.yellow.health.repo.ContactRepository;
import ch.bfh.bti7081.s2018.yellow.health.repo.DoctorRepository;
import ch.bfh.bti7081.s2018.yellow.health.repo.InsuranceRepository;
import ch.bfh.bti7081.s2018.yellow.health.repo.PatientRepository;
import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.AddPatientLayout;
import com.vaadin.event.ShortcutAction.KeyCode;

@SuppressWarnings("serial")
@Component
public class AddPatientViewImpl extends AbsoluteLayout implements AddPatientView {
	
	List<AddPatientViewListener> listeners = new ArrayList<AddPatientViewListener>();
	private AddPatientLayout addPatientForm;
	private AddPatientPresenter presenter;
	AddPatientView view;
	
	@Autowired
	public AddPatientViewImpl(ContactRepository repoContact, PatientRepository repoPatient, DoctorRepository repoDoctor, InsuranceRepository repoInsurance){
        this.presenter=new AddPatientPresenter(this, repoContact, repoPatient);
        addPatientForm = new AddPatientLayout();
        addPatientForm.getBut_Save().addClickListener(e -> this.buttonClick());
        addPatientForm.getBut_Save().setClickShortcut(KeyCode.ENTER);
        this.setDoctorList(repoDoctor.findAll());
        this.setInsuranceList(repoInsurance.findAll());
        addComponent(addPatientForm);
	}
	
	public void setInsuranceList(List<Insurance> insurances){
		addPatientForm.getDd_Insurance().setItems(insurances);
		addPatientForm.getDd_Insurance().setItemCaptionGenerator(e -> e.getName());
	}
	
	public void setDoctorList(List<Doctor> doctors){
		addPatientForm.getDd_Doctor().setItems(doctors);
		addPatientForm.getDd_Doctor().setItemCaptionGenerator(e -> e.getContact().getLastname());
	}
	
	@Override
	public void buttonClick() {
		for (AddPatientViewListener listener: listeners)
			listener.buttonClick();
	}
	
	@Override
	public void addListener(AddPatientViewListener listener) {
		listeners.add(listener);
	}

	@Override
	public String getName() {
		return addPatientForm.getTxt_Name().getValue();
	}
	
	@Override
	public String getFirstName() {
		return addPatientForm.getTxt_FirstName().getValue();
	}

	@Override
	public String getStreet() {
		return addPatientForm.getTxt_Street().getValue();
	}

	@Override
	public Integer getPLZ() {
		return Integer.parseInt(addPatientForm.getTxt_PLZ().getValue());
	}

	@Override
	public String getCity() {
		return addPatientForm.getTxt_City().getValue();
	}

	@Override
	public String getPhone() {
		return addPatientForm.getTxt_Phone().getValue();
	}

	@Override
	public String getMobile() {
		return addPatientForm.getTxt_Mobile().getValue();
	}

	@Override
	public String getMail() {
		return addPatientForm.getTxt_Mail().getValue();
	}

	@Override
	public Date getBirthday() {
		return java.sql.Date.valueOf(addPatientForm.getDf_Birhday().getValue());
	}
	
	@Override
	public Date getStartdate() {
		return java.sql.Date.valueOf(addPatientForm.getDf_Startdate().getValue());
	}

	@Override
	public Date getEnddate() {
		return java.sql.Date.valueOf(addPatientForm.getDf_Enddate().getValue());
	}
	
	@Override
	public Insurance getInsurance() {
		return addPatientForm.getDd_Insurance().getValue();
	}

	@Override
	public Doctor getDoctor() {
		return addPatientForm.getDd_Doctor().getValue();
	}
	
	public void setNotification(){
		addPatientForm.getLbl_Message().setVisible(true);
	}
	
	public boolean check(){
		if(this.getName()!=""){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public AddPatientPresenter getPresenter() {
		return presenter;
	}

	@Override
	public void setName(String name) {
		addPatientForm.getTxt_Name().setValue(name);
	}

	@Override
	public void setFirstName(String firstname) {
		addPatientForm.getTxt_FirstName().setValue(firstname);
	}

	@Override
	public void setStreet(String street) {
		addPatientForm.getTxt_Street().setValue(street);
		
	}

	@Override
	public void setPLZ(Integer plz) {
		addPatientForm.getTxt_PLZ().setValue(plz.toString());
		
	}

	@Override
	public void setCity(String city) {
		addPatientForm.getTxt_City().setValue(city);
	}

	@Override
	public void setPhone(String phone) {
		addPatientForm.getTxt_Phone().setValue(phone);
		
	}

	@Override
	public void setMobile(String mobile) {
		addPatientForm.getTxt_Mobile().setValue(mobile);	
	}

	@Override
	public void setMail(String mail) {
		addPatientForm.getTxt_Mail().setValue(mail);	
	}

	@Override
	public void setBirthday(Date birthday) {
		addPatientForm.getDf_Birhday().setValue(birthday.toLocalDate());
	}

	@Override
	public void setStartdate(Date start) {
		addPatientForm.getDf_Startdate().setValue(start.toLocalDate());
	}

	@Override
	public void setEnddate(Date end) {
		addPatientForm.getDf_Startdate().setValue(end.toLocalDate());
	}

	@Override
	public void setInsurance(Insurance i) {
		addPatientForm.getDd_Insurance().setValue(i);
	}

	@Override
	public void setDoctor(Doctor d) {
		addPatientForm.getDd_Doctor().setValue(d);
	}
	

}
