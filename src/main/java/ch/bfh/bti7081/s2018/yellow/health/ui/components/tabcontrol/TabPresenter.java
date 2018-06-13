package ch.bfh.bti7081.s2018.yellow.health.ui.components.tabcontrol;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.Case;

import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import com.vaadin.ui.TabSheet.Tab;

import ch.bfh.bti7081.s2018.yellow.health.models.Contact;
import ch.bfh.bti7081.s2018.yellow.health.models.Patient;
import ch.bfh.bti7081.s2018.yellow.health.models.User;

public class TabPresenter implements TabControl.TabControlListener {

	
	private Patient patient;
	private TabControl tabview;
	private Tabpage mainpage;
	private List<Tabpage> tabpages = new ArrayList<Tabpage>();
	
	
	public TabPresenter(TabControl tabview) {
		this.tabview = tabview;
		
		tabview.setNotification("TEST", true);
		
		tabview.addListener(this);
	}
	
	@Override
	public void buttonClick(String buttonName) {
		switch (buttonName) {
		case "close":
			UI.getCurrent().getNavigator().navigateTo("Patients");
			break;
		case "save":
			savePatient();
			break;
		}
		
	}

	public void loadPatient(Patient patient) {
		this.patient = patient;
		
		mainpage.setPatient(patient);
		mainpage.loadPatient();
		
		for(Tabpage page : tabpages) {
			page.setPatient(patient);
			page.loadPatient();
		}
		
	}
	
	public void savePatient() {
		if(checkInput()) {
			patient = mainpage.save();
			
			for(Tabpage page : tabpages) {
				page.setPatient(patient);
				page.loadPatient();
			}	
		}
		
	}
	
	public boolean checkInput() {
		if (!mainpage.checkInput()) {
			tabview.setNotification("Bitte überprüfen Sie Ihre Eingaben in Patient", true);
			return false;
		}
		
		for(Tabpage page : tabpages) {
			if(!page.checkInput()) {
				tabview.setNotification("Bitte überprüfen Sie Ihre Eingaben in "+page.getClass().getSimpleName(), true);
				return false;
			}
		}
		
		tabview.setNotification("", false);
		return true;
	}
	
	@Override
	public void addTabpage(Tabpage page) {
		this.tabpages.add(page);
	}


	@Override
	public void setMainpage(Tabpage main) {
		this.mainpage = main;
	}

}
