package ch.bfh.bti7081.s2018.yellow.health.ui.components.history;

import java.sql.Date;

import com.vaadin.ui.UI;

import ch.bfh.bti7081.s2018.yellow.health.models.Historyentry;
import ch.bfh.bti7081.s2018.yellow.health.models.Patient;
import ch.bfh.bti7081.s2018.yellow.health.repo.HistoryEntryRepository;
import ch.bfh.bti7081.s2018.yellow.health.repo.PatientRepository;
import ch.bfh.bti7081.s2018.yellow.health.ui.MyUI;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.tabcontrol.Tabpage;
import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.AddHistoryLayout;
import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.RegistrationLayout;

public class AddHistoryPresenter implements AddHistoryView.AddHistoryViewListener, Tabpage {

	AddHistoryLayout model;
	AddHistoryView view;
	Historyentry historyentry = new Historyentry();
	Patient patient = new Patient();
	private static PatientRepository patientRepo;
	private static HistoryEntryRepository repo;
	
	//Fields
	String title, desc;
	java.sql.Date date;
	
	public AddHistoryPresenter(AddHistoryView  view, HistoryEntryRepository repo){
		this.model = model;
        this.view  = view;
        AddHistoryPresenter.repo = repo;
		System.out.println("AddHistoryPresenter in AddistoryPresenter.java");

        view.addListener(this);
	}

	@Override
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public void loadPatient() {
		//Not used
		return;
	}

	@Override
	public boolean checkInput() {
		System.out.println("checkInput in AddHistoryPresenter.java");
		//Check if all entries are set
		
		try {
			title = view.getTitle();
			date = view.getDate();
			desc = view.getDescription();
		} finally {
			//System.out.println("Can't create requiered variables.");
		}
		
		if(title.isEmpty()) {
			System.out.println("Failure: Title is empty!");
			view.setNotification("Title is empty!", "failure");
			return false;
		}
		
		if(date.toString().isEmpty()) {
			System.out.println("Failure: Date is empty!");
			view.setNotification("Date is empty!", "failure");
			return false;
		}
		
		if(desc.isEmpty()) {
			System.out.println("Failure: Description is empty!");
			view.setNotification("Description is empty!", "failure");
			return false;
		}
		System.out.println("Check Ok");
		return true;
	}

	@Override
	public Patient save() {
		//Save Entry
		System.out.println("Success: Create Entry!");
		patient.setPatientID(1);
		historyentry.createEntry(patient, title, desc, (byte) 1, date);
		
		System.out.println("Patient: " + historyentry.getPatient().getPatientID());
		System.out.println("Title: "+ historyentry.getTitle());
		System.out.println("Entry: "+ historyentry.getEntry());
		System.out.println("Active: "+historyentry.getActive());
		System.out.println("Date: "+historyentry.getDate());
		repo.save(historyentry);
		
		view.setNotification("Entry added to history", "success");
		
		return this.patient;
	}
	
	
}
