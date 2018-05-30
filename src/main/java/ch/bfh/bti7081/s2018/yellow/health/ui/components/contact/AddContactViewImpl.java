package ch.bfh.bti7081.s2018.yellow.health.ui.components.contact;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vaadin.ui.AbsoluteLayout;

import ch.bfh.bti7081.s2018.yellow.health.repo.ContactRepository;
import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.AddContactLayout;

@SuppressWarnings("serial")
@Component
public class AddContactViewImpl extends AbsoluteLayout implements AddContactView{

	List<AddContactViewListener> listeners = new ArrayList<AddContactViewListener>();
	private AddContactPresenter presenter;
	private AddContactLayout addContactForm;
	
	public AddContactViewImpl(ContactRepository repo){
		this.presenter = new AddContactPresenter(this, repo);
		addContactForm = new AddContactLayout();
		addContactForm.getBut_Save().addClickListener(e -> this.buttonClick());
		addComponent(addContactForm);
	}
	
	@Override
	public void buttonClick() {
		for (AddContactViewListener listener: listeners){
			listener.buttonClick();
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
	public Integer getPLZ() {
		return Integer.parseInt(addContactForm.getTxt_PLZ().getValue());
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

}
