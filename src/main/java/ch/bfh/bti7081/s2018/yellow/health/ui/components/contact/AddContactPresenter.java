package ch.bfh.bti7081.s2018.yellow.health.ui.components.contact;

import ch.bfh.bti7081.s2018.yellow.health.models.Contact;
import ch.bfh.bti7081.s2018.yellow.health.repo.ContactRepository;

public class AddContactPresenter implements AddContactView.AddContactViewListener {

	Contact model;
	AddContactViewImpl view;
	ContactRepository ContactRepository;
	Contact contact = new Contact();
	
	public AddContactPresenter(AddContactViewImpl view, ContactRepository ContactRepository){
		this.model = model;
		this.view = view;
		this.ContactRepository = ContactRepository;
		this.contact = new Contact();
		view.addListener(this);
	}
	
	public void buttonClick() {
		//get Form-input and save Contact
		if(view.checkInput() == true){
			view.setNotification(false);
			contact.createContact(view.getFirstName(), view.getName(), view.getStreet(), view.getPLZ(), view.getCity(), view.getPhone(), view.getMobile(), view.getMail(),view.getBirthday());
			ContactRepository.save(contact);
		}
		else{
			view.setNotification(true);
		}
	}

}