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
import com.vaadin.ui.DateField;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;

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
        presenter=new AddPatientPresenter(this, repoContact, repoPatient);
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
	public String getPLZ() {
		return addPatientForm.getTxt_PLZ().getValue();
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
	
	public AddPatientLayout getLayout(){
		return addPatientForm;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFirstName(String firstname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStreet(String street) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPLZ(String plz) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCity(String city) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPhone(String phone) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMobile(String mobile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMail(String mail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStartdate(Date start) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnddate(Date end) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setInsurance(Insurance i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDoctor(Doctor d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBirthday(Date date) {
		// TODO Auto-generated method stub
		
	}
}
