package ch.bfh.bti7081.s2018.yellow.health.ui.navigation;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.server.Resource;

import ch.bfh.bti7081.s2018.yellow.health.ui.components.patient.AddPatientView;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.searchcontact.SearchContactView;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.searchpatient.SearchPatientView;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.contact.AddContactView;

public enum AppViewType {
    CONTACT("Kontakte",SearchContactView.class, VaadinIcons.HOME),
    PATIENT("Patienten",SearchPatientView.class, VaadinIcons.HOME),
    ADDCONTACT("neuer Kontakt",AddContactView.class, VaadinIcons.HOME),
	ADDPATIENT("Neuer Patient",AddPatientView.class, VaadinIcons.HOME);

    private final String viewName;
    private final Class<? extends View> viewClass;
    private final Resource icon;

    AppViewType(final String viewName, final Class<? extends View> viewClass, final Resource icon) {
        this.viewName = viewName;
        this.viewClass = viewClass;
        this.icon = icon;
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

