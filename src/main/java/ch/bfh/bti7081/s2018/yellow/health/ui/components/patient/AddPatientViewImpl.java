package ch.bfh.bti7081.s2018.yellow.health.ui.components.patient;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;

import ch.bfh.bti7081.s2018.yellow.health.repo.ContactRepository;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.login.LoginView.LoginViewListener;
import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.AddPatientLayout;

@SuppressWarnings("serial")
@Component
public class AddPatientViewImpl extends AbsoluteLayout implements AddPatientView {
	
	List<AddPatientViewListener> listeners = new ArrayList<AddPatientViewListener>();
	private AddPatientPresenter presenter;
	private AddPatientLayout addPatientForm;
	
	@Autowired
	public AddPatientViewImpl(ContactRepository repo){
		this.presenter = new AddPatientPresenter(this, repo);
        addPatientForm = new AddPatientLayout();
        addPatientForm.getBut_Save().addClickListener(e -> this.buttonClick());
		addComponent(addPatientForm);
		//setComponentAlignment(addPatientForm, Alignment.MIDDLE_CENTER);
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
	

}
