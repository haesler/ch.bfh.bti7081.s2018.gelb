package ch.bfh.bti7081.s2018.yellow.health.ui.components.patient;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.sass.internal.parser.ParseException;

import ch.bfh.bti7081.s2018.yellow.health.models.Contact;
import ch.bfh.bti7081.s2018.yellow.health.models.Patient;
import ch.bfh.bti7081.s2018.yellow.health.repo.ContactRepository;
import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.AddPatientLayout;

@SuppressWarnings("serial")
public class AddPatientPresenter implements AddPatientView.AddPatientViewListener {

	Patient model;
	AddPatientView view;
	ContactRepository ContactRepository;
	Patient patient = new Patient();
	Contact contact = new Contact();
	
	public AddPatientPresenter(AddPatientView view, ContactRepository ContactRepository){
		this.model=model;
		this.view=view;
		this.ContactRepository=ContactRepository;
		this.patient=patient;
		this.contact = new Contact();
		this.patient = new Patient();
		view.addListener(this);
	}
	
	//Es fehlt ein Doctor, Insurance, User Objekt --> Am besten Dropdown von SELECT * FROM <TBL>
	
	public void buttonClick() {
		//System.out.println("ja");
		//view.setNotification();
		
		/*String Birthday=view.getBirthday();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date date;
		java.sql.Date Birthday_SQL = new java.sql.Date(0);
		try {
			date = formatter.parse(Birthday);
			Birthday_SQL = new java.sql.Date(date.getTime()); 
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//Save Contact
		contact.createContact(view.getFirstName(), view.getName(), view.getStreet(), view.getPLZ(), view.getCity(), view.getPhone(), view.getMobile(), view.getMail(),view.getBirthday());
		ContactRepository.save(contact);
		
		//Mayby baby
		//contact.setContactID(contact.getContactID());
		
		//Save Patient
		//patient.createPatient(true, start, end, contact, insurance, doctor, user);
		
		//addPatientRepo.modifyingQueryInsertContact("Fabian", "Zurbuchen", "Lochweg", 3114, "Wichtrach", "031", "079", "fabian.zurbuchen@gmail.com", Birthday);
		//addPatientRepo.modifyingQueryInsertContact(view.getFirstName(), view.getName(), view.getStreet(), view.getPLZ(), view.getCity(), view.getPhone(), view.getMobile(), view.getMail(), Birthday_SQL);
		//addPatientRepo.save(contact);
		//addPatientRepo.modifyingQueryInsertContact("Fabian", "", Street, PLZ, City, Phone, Mobile, Mail, Birthday)
	}
	

}
