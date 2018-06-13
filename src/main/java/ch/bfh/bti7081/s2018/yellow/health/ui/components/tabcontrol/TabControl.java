package ch.bfh.bti7081.s2018.yellow.health.ui.components.tabcontrol;


import com.vaadin.navigator.View;
import com.vaadin.ui.TabSheet;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.history.AddHistoryViewImpl;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.medication.AddMedicationViewImpl;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.patient.AddPatientViewImpl;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.searchMedication.SearchMedicationvVewImpl;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.searchhistory.SearchHistoryViewImpl;

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
	public AddHistoryViewImpl getTabpage2();
	public AddMedicationViewImpl getTabpage3();
	public SearchHistoryViewImpl getTabpage4();
	public SearchMedicationvVewImpl getTabpage5();
	public void setNotification(String value,boolean visible);

}
