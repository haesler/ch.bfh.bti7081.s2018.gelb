package ch.bfh.bti7081.s2018.yellow.health.ui.components.patient;

import java.time.LocalDateTime;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.DateTimeField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.s2018.yellow.health.models.Patient;

public class PatientViewImpl extends VerticalLayout implements PatientView {
	
	private TabSheet tab;
	private VerticalLayout tabpage_1;
	
	
	private DateField birthday;
	private TextField street;
	private TextField plz;
	private TextField city;
	private TextField firstname;
	private TextField lastname;
	private TextField mail;
	private TextField mobile;
	private TextField phone;
	private DateTimeField start;
	private DateTimeField end;
	
	public PatientViewImpl() {
        tab = new TabSheet();
        tab.setHeight(100.0f, Unit.PERCENTAGE);
        tab.addStyleName(ValoTheme.TABSHEET_FRAMED);
        tab.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
        
        initPage1();
        tab.addTab(tabpage_1, "Patientendaten");
        
        addComponent(tab);
		setComponentAlignment(tab, Alignment.MIDDLE_CENTER);
	}
	
	public void initPage1() {
		tabpage_1 = new VerticalLayout();
		
		start = new DateTimeField("Patient von ");
		start.setValue(LocalDateTime.now());
		start.addStyleName("inline-label");
		
		
		end = new DateTimeField(" bis ");
		end.setValue(LocalDateTime.now());
		end.addStyleName("inline-label");
		
		HorizontalLayout zeit = new HorizontalLayout();
		zeit.addComponent(start);
		zeit.addComponent(end);
		
		FormLayout form = new FormLayout();
		
		birthday = new DateField("Geburtstag");
		street = new TextField("Strasse");
		plz = new TextField("PLZ ");
		city = new TextField("Ort");
		firstname = new TextField("Vorname");
		lastname = new TextField("Nachname");
		mail = new TextField("E-Mail");
		mobile = new TextField("Mobile ");
		phone = new TextField("Telefon ");
		
		form.addComponent(zeit);
		form.addComponent(birthday);
		form.addComponent(firstname);
		form.addComponent(lastname);
		form.addComponent(plz);
		form.addComponent(mail);
		form.addComponent(mobile);
		form.addComponent(phone);
		
		tabpage_1.addComponent(form);
		
	}
	
	@Override
	public void addListener(PatientViewListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPatient(Patient patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearText(TextField txtField) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public VerticalLayout filterInit() {
		// TODO Auto-generated method stub
		return null;
	}

}
