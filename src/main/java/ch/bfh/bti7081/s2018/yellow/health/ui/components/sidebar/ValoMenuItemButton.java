package ch.bfh.bti7081.s2018.yellow.health.ui.components.sidebar;

import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

import ch.bfh.bti7081.s2018.yellow.health.ui.navigation.AppViewType;

public final class ValoMenuItemButton extends Button {

    private static final String STYLE_SELECTED = "selected";

    private final AppViewType view;

    public ValoMenuItemButton (final AppViewType view) {
        this.view = view;
        setPrimaryStyleName("valo-menu-item");
        setIcon(view.getIcon());
        setCaption(view.getViewName().substring(0, 1).toUpperCase() + view.getViewName().substring(1));
        addClickListener((ClickListener) event -> UI.getCurrent().getNavigator().navigateTo(view.getViewName()));

    }
}
