package ch.bfh.bti7081.s2018.yellow.health.ui.components.contact;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;

import ch.bfh.bti7081.s2018.yellow.health.repo.ContactRepository;
import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.AddContactLayout;
import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.AddPatientLayout;

@SuppressWarnings("serial")
@Component
public class AddContactViewImpl extends AbsoluteLayout implements AddContactView{

	List<AddContactViewListener> listeners = new ArrayList<AddContactViewListener>();
	private AddContactPresenter presenter;
	private AddContactLayout addContactForm;
	
	public AddContactViewImpl(ContactRepository repo){
		
		HorizontalLayout layout = new HorizontalLayout();
		
		this.presenter = new AddContactPresenter(this, repo);
		addContactForm = new AddContactLayout();
		addContactForm.getBut_Save().setId("save");
		addContactForm.getBut_Save().addClickListener(e -> this.buttonClick(e.getButton().getId()));
		addContactForm.setSizeFull();
		
		layout.addComponent(addContactForm);
		layout.setExpandRatio(addContactForm, 1.0f);
		layout.setComponentAlignment(addContactForm, Alignment.MIDDLE_CENTER);
		
		Button close = new Button(VaadinIcons.CLOSE);
		close.setId("close");
		close.setSizeUndefined();
		close.addClickListener(e -> this.buttonClick(e.getButton().getId()));
		
		layout.addComponent(close);
		layout.setComponentAlignment(close, Alignment.MIDDLE_LEFT);
		
		layout.setSizeFull();
		addComponent(layout);
	}
	
	public AddContactPresenter getPresenter() {
		return this.presenter;
	}
	
	@Override
	public void buttonClick(String id) {
		for (AddContactViewListener listener: listeners){
			listener.buttonClick(id);
		}
	}
	
	@Override
	public void addListener(AddContactViewListener listener) {
		listeners.add(listener);
	}

	@Override
	public String getName() {
		return addContactForm.getTxt_Name().getValue();
	}

	@Override
	public String getFirstName() {
		return addContactForm.getTxt_FirstName().getValue();
	}

	@Override
	public String getStreet() {
		return addContactForm.getTxt_Street().getValue();
	}

	@Override
	public String getPLZ() {
		return addContactForm.getTxt_PLZ().getValue();
	}

	@Override
	public String getCity() {
		return addContactForm.getTxt_City().getValue();
	}

	@Override
	public String getPhone() {
		return addContactForm.getTxt_Phone().getValue();
	}

	@Override
	public String getMobile() {
		return addContactForm.getTxt_Mobile().getValue();
	}

	@Override
	public String getMail() {
		return addContactForm.getTxt_Mail().getValue();
	}

	@Override
	public Date getBirthday() {
		return java.sql.Date.valueOf(addContactForm.getDf_Birhday().getValue());
	}
	
	public void setNotification(Boolean value){
		addContactForm.getLbl_Message().setVisible(value);
	}
	
	public boolean checkInput(){
		if(this.getName()!="" && this.getFirstName()!=""){
			return true;
		}
		else{
			return false;
		}
	}
	
	public AddContactLayout getLayout(){
		return addContactForm;
	}

	@Override
	public void setName(String name) {
		addContactForm.getTxt_Name().setValue(name);
	}

	@Override
	public void setFirstName(String firstname) {
		addContactForm.getTxt_FirstName().setValue(firstname);
	}

	@Override
	public void setStreet(String street) {
		addContactForm.getTxt_Street().setValue(street);
		
	}

	@Override
	public void setPLZ(String plz) {
		addContactForm.getTxt_PLZ().setValue(plz.toString());
		
	}

	@Override
	public void setCity(String city) {
		addContactForm.getTxt_City().setValue(city);
		
	}

	@Override
	public void setPhone(String phone) {
		addContactForm.getTxt_Phone().setValue(phone);
		
	}

	@Override
	public void setMobile(String mobile) {
		addContactForm.getTxt_Mobile().setValue(mobile);
		
	}

	@Override
	public void setMail(String mail) {
		addContactForm.getTxt_Mail().setValue(mail);
		
	}

	@Override
	public void setBirthday(Date birthday) {
		addContactForm.getDf_Birhday().setValue(birthday.toLocalDate());
	}

	

}
