package ch.bfh.bti7081.s2018.yellow.health.ui.components.tabcontrol;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.s2018.yellow.health.models.Patient;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.medication.AddMedicationView;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.medication.AddMedicationViewImpl;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.patient.AddPatientView;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.patient.AddPatientViewImpl;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.patient.AddPatientView.AddPatientViewListener;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.searchpatient.SearchPatientView.SearchPatientViewListener;
import ch.bfh.bti7081.s2018.yellow.health.ui.navigation.AppViewType;

@Component
public class TabControlImpl extends VerticalLayout implements TabControl {
	
	private TabPresenter presenter;
	private TabSheet tab;
	private AddPatientViewImpl tabpage_1;
	private AddPatientViewImpl tabpage_2;
	private AddMedicationViewImpl tabpage_3;
	private Label notification;
	List<TabControlListener> listeners = new ArrayList<TabControlListener>();
	
	@Autowired
	public TabControlImpl(ApplicationContext context) {
		
		
		this.tabpage_1 = context.getBean(AddPatientViewImpl.class);
		this.tabpage_2 = context.getBean(AddPatientViewImpl.class);
		this.tabpage_3 = context.getBean(AddMedicationViewImpl.class);
		
		
		this.tabpage_1.setSizeFull();
		this.tabpage_2.setSizeFull();
		this.tabpage_3.setSizeFull();
		
		HorizontalLayout layout = new HorizontalLayout();
		layout.setSizeFull();
		
        tab = new TabSheet();
        tab.addStyleName(ValoTheme.TABSHEET_FRAMED);
        tab.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
        
        tab.addTab(this.tabpage_1, "Patientendaten");
       // tab.addTab(this.tabpage_2, "Krankheitsverlauf");
        tab.addTab(this.tabpage_3, "Medikation");
        tab.setSizeFull();
        
        
        layout.addComponent(tab);
        layout.setExpandRatio(tab, 1.0f);
		layout.setComponentAlignment(tab, Alignment.MIDDLE_CENTER);
		
		Button close = new Button(VaadinIcons.CLOSE);
		close.setId("close");
		close.setSizeUndefined();
		close.addClickListener(e -> this.buttonClick(e.getButton()));
		
		layout.addComponent(close);
		layout.setComponentAlignment(close, Alignment.TOP_RIGHT);
		
		HorizontalLayout bottom = new HorizontalLayout(); 
		bottom.setSizeUndefined();
		
		Button save = new Button("Speichern");
		save.setId("save");
		save.setSizeUndefined();
		save.addClickListener(e -> this.buttonClick(e.getButton()));
		bottom.addComponent(save);
		
		
		notification = new Label("");
		//notification.addStyleName("failure");
		notification.setSizeFull();
		bottom.addComponent(notification);
		
		bottom.setExpandRatio(notification, 1.0f);
		
        addComponent(layout);
        setExpandRatio(layout, 1.0f);
        addComponent(bottom);
		setComponentAlignment(layout, Alignment.TOP_CENTER);
		
		setSizeFull();
		
		this.presenter = new TabPresenter(this);
		
		for (TabControlListener listener: listeners) {
			listener.setMainpage(this.tabpage_1.getPresenter());
			listener.addTabpage(this.tabpage_2.getPresenter());
			listener.addTabpage(this.tabpage_3.getPresenter());
		}
		
	}

	private void buttonClick(Button button) {
		for (TabControlListener listener: listeners)
			listener.buttonClick(button.getId());
	}

	@Override
	public void addListener(TabControlListener listener) {
		listeners.add(listener);
		
	}

	public TabPresenter getPresenter() {
		return presenter;
	}

	@Override
	public TabSheet getTab() {
		return tab;
	}

	@Override
	public AddPatientViewImpl getTabpage1() {
		return tabpage_1;
	}

	@Override
	public AddPatientViewImpl getTabpage2() {
		return tabpage_2;
	}

	@Override
	public AddMedicationViewImpl getTabpage3() {
		return tabpage_3;
	}

	@Override
	public void setNotification(String value,boolean visible) {
		notification.setVisible(visible);
		notification.setValue(value);
		
	}
}
