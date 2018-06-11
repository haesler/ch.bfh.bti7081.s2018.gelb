package ch.bfh.bti7081.s2018.yellow.health.ui.components.contact;


import com.vaadin.ui.Notification;
import ch.bfh.bti7081.s2018.yellow.health.models.Contact;
import ch.bfh.bti7081.s2018.yellow.health.repo.ContactRepository;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.validate.ContactValidate;

public class AddContactPresenter implements AddContactView.AddContactViewListener {

	Contact model;
	//AddContactViewImpl view;
	AddContactView view;
	ContactRepository ContactRepository;
	ContactValidate validateContact;
	Contact contact = new Contact();
	
	public AddContactPresenter(AddContactView view, ContactRepository ContactRepository){
		this.model = model;
		this.view = view;
		this.ContactRepository = ContactRepository;
		this.contact = new Contact();
		validateContact = new ContactValidate();
		view.addListener(this);
	}
	
	public void buttonClick() {
		//get Form-input and save Contact
		/*if(view.checkInput() == true){
			view.setNotification(false);
			contact.createContact(view.getFirstName(), view.getName(), view.getStreet(), view.getPLZ(), view.getCity(), view.getPhone(), view.getMobile(), view.getMail(),view.getBirthday());
			ContactRepository.save(contact);
		}
		else{
			view.setNotification(true);
		}*/
		//validateContact.isValid(view.getLayout().getTxt_FirstName(), view.getLayout().getTxt_Name(), view.getLayout().getTxt_Street(), view.getLayout().getTxt_PLZ(), view.getLayout().getTxt_City(), view.getLayout().getTxt_Phone(), view.getLayout().getTxt_Mobile(), view.getLayout().getTxt_Mail(),view.getLayout().getDf_Birhday());
		
		
		if(
				validateContact.isValid(view.getLayout().getTxt_FirstName(), view.getLayout().getTxt_Name(), view.getLayout().getTxt_Street(), view.getLayout().getTxt_PLZ(), view.getLayout().getTxt_City(), view.getLayout().getTxt_Phone(), view.getLayout().getTxt_Mobile(), view.getLayout().getTxt_Mail(),view.getLayout().getDf_Birhday())
		)		
		{
			contact.createContact(view.getFirstName(), view.getName(), view.getStreet(), view.getPLZ(), view.getCity(), view.getPhone(), view.getMobile(), view.getMail(),view.getBirthday());
			ContactRepository.save(contact);
			Notification.show("Contact successfully saved");
		}
			
			
			
	}

	public void loadContact(Contact contact) {
		this.contact = contact;
		view.setName(contact.getLastname());
		view.setFirstName(contact.getFirstname());
		view.setStreet(contact.getStreet());
		view.setPLZ(contact.getPlz());
		view.setCity(contact.getCity());
		view.setPhone(contact.getPhone());
		view.setMobile(contact.getMobile());
		view.setMail(contact.getMail());
		view.setBirthday(new java.sql.Date(contact.getBirthday().getTime()));
	}

}
