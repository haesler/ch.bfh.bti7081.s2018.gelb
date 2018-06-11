package ch.bfh.bti7081.s2018.yellow.health.ui.components.patient;



import com.vaadin.ui.Notification;

import ch.bfh.bti7081.s2018.yellow.health.models.Contact;
import ch.bfh.bti7081.s2018.yellow.health.models.Patient;
import ch.bfh.bti7081.s2018.yellow.health.models.User;
import ch.bfh.bti7081.s2018.yellow.health.repo.ContactRepository;
import ch.bfh.bti7081.s2018.yellow.health.repo.PatientRepository;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.patient.*;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.validate.ContactValidate;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.validate.PatientValidate;


@SuppressWarnings("serial")
public class AddPatientPresenter implements AddPatientView.AddPatientViewListener {


	Patient model;
	AddPatientView view;
	ContactRepository repoContact;
	PatientRepository repoPatient;
	PatientValidate validatePatient;
	ContactValidate validateContact;
	Patient patient = new Patient();
	Contact contact = new Contact();
	User user = new User();
	
	
	public AddPatientPresenter(AddPatientView view, ContactRepository repoContact, PatientRepository repoPatient){
		this.model=model;
		this.view=view;
		this.repoContact=repoContact;
		this.repoPatient=repoPatient;
		this.patient=patient;
		validatePatient = new PatientValidate();
		validateContact = new ContactValidate();
		view.addListener(this);	
		
	}
	

	
	public void loadPatient(Patient patient) {
		this.patient = patient;
		this.contact=patient.getContact();
		view.setName(contact.getLastname());
		view.setFirstName(contact.getFirstname());
		view.setStreet(contact.getStreet());
		view.setPLZ(contact.getPlz());
		view.setCity(contact.getCity());
		view.setPhone(contact.getPhone());
		view.setMobile(contact.getMobile());
		view.setMail(contact.getMail());
		view.setBirthday(new java.sql.Date(contact.getBirthday().getTime()));
		view.setStartdate(new java.sql.Date(patient.getStart().getTime()));
		view.setEnddate(new java.sql.Date(patient.getEnd().getTime()));
		view.setDoctor(patient.getDoctor());
		view.setInsurance(patient.getInsurance());
	}
	
	public void buttonClick() {
		validateContact.isValid(view.getLayout().getTxt_FirstName(), view.getLayout().getTxt_Name(), view.getLayout().getTxt_Street(), view.getLayout().getTxt_PLZ(), view.getLayout().getTxt_City(), view.getLayout().getTxt_Phone(), view.getLayout().getTxt_Mobile(), view.getLayout().getTxt_Mail(),view.getLayout().getDf_Birhday());
		validatePatient.isValid(view.getLayout().getDf_Startdate(), view.getLayout().getDf_Enddate(), view.getLayout().getDd_Insurance(), view.getLayout().getDd_Doctor());
		//Validate Input Data
		if(
				validateContact.isValid(view.getLayout().getTxt_FirstName(), view.getLayout().getTxt_Name(), view.getLayout().getTxt_Street(), view.getLayout().getTxt_PLZ(), view.getLayout().getTxt_City(), view.getLayout().getTxt_Phone(), view.getLayout().getTxt_Mobile(), view.getLayout().getTxt_Mail(),view.getLayout().getDf_Birhday())
				&& validatePatient.isValid(view.getLayout().getDf_Startdate(), view.getLayout().getDf_Enddate(), view.getLayout().getDd_Insurance(), view.getLayout().getDd_Doctor())
		){
			System.out.println("lets save");
			
			contact.createContact(view.getFirstName(), view.getName(), view.getStreet(), view.getPLZ(), view.getCity(), view.getPhone(), view.getMobile(), view.getMail(),view.getBirthday());
			repoContact.save(contact);
			
			//Save Patient
			byte active = 1;
			user.setUsername("test");
			user.setUserID(1);
			patient.createPatient(active, view.getStartdate(), view.getEnddate(), contact, view.getInsurance(), view.getDoctor(), user);
			repoPatient.save(patient);
			Notification.show("Patient successfully saved");
		}
				
	}
	

}
