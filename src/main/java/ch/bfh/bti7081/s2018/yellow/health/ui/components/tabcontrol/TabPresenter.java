package ch.bfh.bti7081.s2018.yellow.health.ui.components.tabcontrol;

import java.util.Iterator;

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
	
	
	public TabPresenter(TabControl tabview) {
		this.tabview = tabview;
		System.out.println("TabPresenter constructor");
		
		tabview.addListener(this);
	}
	
	
	@Override
	public void buttonClick(String buttonName) {
		switch (buttonName) {
		case "close":
			UI.getCurrent().getNavigator().navigateTo("Patienten");
			break;
		case "save":
			savePatient();
			break;
		}
		
	}

	@Override
	public void valueChange(String txtFieldName, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadPatient(Patient patient) {
		this.patient = patient;
		
		tabview.getTabpage1().getPresenter().setPatient(patient);
		tabview.getTabpage1().getPresenter().loadPatient();
		//tabview.getTabpage2().getPresenter().loadPatient(patient);
		tabview.getTabpage3().getPresenter().setPatient(patient);
		tabview.getTabpage3().getPresenter().loadPatient();
		
	}
	
	@Override
	public void savePatient() {
		//todo CheckInput
		
		patient = tabview.getTabpage1().getPresenter().save();
		//tabview.getTabpage2().getPresenter().setPatient(patient);
		tabview.getTabpage3().getPresenter().setPatient(patient);
		
		tabview.getTabpage2().getPresenter().save();
		tabview.getTabpage3().getPresenter().save();
		
	}

}
