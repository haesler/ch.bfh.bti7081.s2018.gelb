package ch.bfh.bti7081.s2018.yellow.health.ui.navigation;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.server.Resource;

import ch.bfh.bti7081.s2018.yellow.health.ui.components.tabcontrol.TabControl;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.searchcontact.SearchContactView;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.searchpatient.SearchPatientView;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.contact.AddContactView;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.medicament.AddMedicamentView;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.medication.AddMedicationView;

public enum AppViewType {
    CONTACT("Kontakte",SearchContactView.class, VaadinIcons.HOME,true),
    PATIENT("Patienten",SearchPatientView.class, VaadinIcons.HOME,true),
	ADDPATIENT("AddPatient",TabControl.class, VaadinIcons.HOME,false),
    ADDCONTACT("neuer Kontakt",AddContactView.class, VaadinIcons.HOME,true),
	PATIENTEDIT("EditPatient",TabControl.class, VaadinIcons.HOME,false),
	CONTACTEDIT("EditContact",AddContactView.class, VaadinIcons.HOME,false),
	MEDICAMENT("Medikamente",AddMedicamentView.class, VaadinIcons.HOME,true),
	MEDICATION("Medikation",AddMedicationView.class, VaadinIcons.HOME,true);

    private final String viewName;
    private final Class<? extends View> viewClass;
    private final Resource icon;
    private final boolean show;

    AppViewType(final String viewName, final Class<? extends View> viewClass, final Resource icon, final boolean show) {
        this.viewName = viewName;
        this.viewClass = viewClass;
        this.icon = icon;
        this.show = show;
    }
    
    public static AppViewType getByViewName(final String viewName) {
    	AppViewType result = null;
        for (AppViewType viewType : values()) {
            if (viewType.getViewName().equals(viewName)) {
                result = viewType;
                break;
            }
        }
        return result;
    }
    
    public boolean isVisible() {
    	return show;
    }

    public String getViewName() {
        return viewName;
    }

    public Class<? extends View> getViewClass() {
        return viewClass;
    }

    public Resource getIcon() {
        return icon;
    }
}

