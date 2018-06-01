package ch.bfh.bti7081.s2018.yellow.health.ui.components.patient;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.sass.internal.parser.ParseException;

import ch.bfh.bti7081.s2018.yellow.health.models.Contact;
import ch.bfh.bti7081.s2018.yellow.health.models.Patient;
import ch.bfh.bti7081.s2018.yellow.health.models.User;
import ch.bfh.bti7081.s2018.yellow.health.repo.ContactRepository;
import ch.bfh.bti7081.s2018.yellow.health.repo.PatientRepository;
import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.AddPatientLayout;

@SuppressWarnings("serial")
public class AddPatientPresenter implements AddPatientView.AddPatientViewListener {

	AddPatientLayout model;
	AddPatientView view;
	ContactRepository repoContact;
	PatientRepository repoPatient;
	Patient patient = new Patient();
	Contact contact = new Contact();
	User user = new User();
	
	
	public AddPatientPresenter(AddPatientView view, ContactRepository repoContact, PatientRepository repoPatient){
		this.view=view;
		this.repoContact=repoContact;
		this.repoPatient=repoPatient;
		view.addListener(this);	
		
	}
	
	/*public AddPatientPresenter(AddPatientView view, ContactRepository ContactRepository, PatientRepository PatientRepository){
		this.view=view;
		view.addListener(this);	
		this.ContactRepository=ContactRepository;
		this.PatientRepository=PatientRepository;
		this.contact = new Contact();
		this.patient = new Patient();	
	}
	*/
	
	public void buttonClick() {
		
		System.out.println("da");
		//Save Contact
		contact.createContact(view.getFirstName(), view.getName(), view.getStreet(), view.getPLZ(), view.getCity(), view.getPhone(), view.getMobile(), view.getMail(),view.getBirthday());
		repoContact.save(contact);
		
		//Save Patient
		byte active = 1;
		user.setUsername("faebu");
		user.setUserID(1);
		patient.createPatient(active, view.getStartdate(), view.getEnddate(), contact, view.getInsurance(), view.getDoctor(), user);
		repoPatient.save(patient);
	}
	

}
