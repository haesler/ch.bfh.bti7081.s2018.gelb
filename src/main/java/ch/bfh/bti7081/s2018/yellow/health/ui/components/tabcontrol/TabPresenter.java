package ch.bfh.bti7081.s2018.yellow.health.ui.components.tabcontrol;

import java.util.ArrayList;
import java.util.List;
import com.vaadin.ui.UI;
import ch.bfh.bti7081.s2018.yellow.health.models.Patient;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.searchcontact.SearchContactViewImpl;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.searchpatient.SearchPatientPresenter;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.searchpatient.SearchPatientViewImpl;

public class TabPresenter implements TabControl.TabControlListener {

	
	private Patient patient;
	private TabControl tabview;
	private Tabpage mainpage;
	private List<Tabpage> tabpages = new ArrayList<Tabpage>();
	
	
	public TabPresenter(TabControl tabview) {
		this.tabview = tabview;
		
		
		tabview.addListener(this);
	}
	
	@Override
	public void buttonClick(String buttonName) {
		switch (buttonName) {
		case "close":
			UI.getCurrent().getNavigator().navigateTo("Patients");
			((SearchPatientViewImpl)UI.getCurrent().getNavigator().getCurrentView()).getPresenter().refresh();
			break;
		case "save":
			savePatient();
			break;
		}
		
	}

	/**
	 * Sets Patient-Model on every Tabpage and loads Data
	 */
	public void loadPatient(Patient patient) {
		this.patient = patient;
		
		mainpage.setPatient(patient);
		mainpage.loadPatient();
		
		for(Tabpage page : tabpages) {
			page.setPatient(patient);
			page.loadPatient();
		}
		tabview.setNotification("", false);
		
	}

	/**
	 * Saves first Patient-Data and afterwards Data on every other Tabpage
	 */
	public void savePatient() {
		if(checkInput()) {
			patient = mainpage.save();
			
			/*for(Tabpage page : tabpages) {
				page.setPatient(patient);
				page.loadPatient();
			}*/	
		}
		
	}
	
	/**
	 * Validates Data of every Tabpage
	 */
	public boolean checkInput() {
		if (!mainpage.checkInput()) {
			tabview.setNotification("Please check your input on Patient-Tabpage", true);
			return false;
		}
		
		/*for(Tabpage page : tabpages) {
			if(!page.checkInput()) {
				tabview.setNotification("Please check your input  "+ page.getClass().getSimpleName(), true);
				return false;
			}
		}*/
		
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
