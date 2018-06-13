package ch.bfh.bti7081.s2018.yellow.health.ui.components.tabcontrol;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.bti7081.s2018.yellow.health.models.Patient;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.medication.AddMedicationViewImpl;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.patient.AddPatientViewImpl;

public interface TabControl extends View {
	
	interface TabControlListener {
        void buttonClick(String buttonName);
        void addTabpage(Tabpage page);
        void setMainpage(Tabpage main);
    }
	
	public void addListener(TabControlListener listener);
	
	public TabPresenter getPresenter();
	
	public TabSheet getTab();
	public AddPatientViewImpl getTabpage1();
	public AddPatientViewImpl getTabpage2();
	public AddMedicationViewImpl getTabpage3();
	public void setNotification(String value,boolean visible);

}
