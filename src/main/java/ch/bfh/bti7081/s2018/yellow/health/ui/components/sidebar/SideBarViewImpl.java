package ch.bfh.bti7081.s2018.yellow.health.ui.components.sidebar;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.DragAndDropWrapper.DragStartMode;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.s2018.yellow.health.ui.components.login.AuthService;
import ch.bfh.bti7081.s2018.yellow.health.ui.navigation.AppViewType;

import java.util.Collection;

import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;

public class SideBarViewImpl extends CustomComponent implements SideBarView, ClickListener {

    public static final String ID = "dashboard-menu";
    public static final String REPORTS_BADGE_ID = "dashboard-menu-reports-badge";
    public static final String NOTIFICATIONS_BADGE_ID = "dashboard-menu-notifications-badge";
    private static final String STYLE_VISIBLE = "valo-menu-visible";
    private Label notificationsBadge;
    private Label reportsBadge;
    private MenuItem settingsItem;
	
	public SideBarViewImpl() {
	    setPrimaryStyleName("valo-menu");
	    setId(ID);
	    setSizeUndefined();

	    setCompositionRoot(buildContent());
	}
	
	
	private Component buildContent() {
	    final CssLayout menuContent = new CssLayout();
	    menuContent.addStyleName("sidebar");
	    menuContent.addStyleName(ValoTheme.MENU_PART);
	    menuContent.addStyleName("no-vertical-drag-hints");
	    menuContent.addStyleName("no-horizontal-drag-hints");
	    menuContent.setWidth(null);
	    menuContent.setHeight("100%");

	    menuContent.addComponent(buildTitle());
	    menuContent.addComponent(buildUserMenu());
	    menuContent.addComponent(buildToggleButton());
	    menuContent.addComponent(buildMenuItems());

	    return menuContent;
	}
	
	private Component buildTitle() {
	    Label logo = new Label("<strong>Team-Yellow PMS</strong>",
	            ContentMode.HTML);
	    logo.setSizeUndefined();
	    HorizontalLayout logoWrapper = new HorizontalLayout(logo);
	    logoWrapper.setComponentAlignment(logo, Alignment.MIDDLE_CENTER);
	    logoWrapper.addStyleName("valo-menu-title");
	    logoWrapper.setSpacing(false);
	    return logoWrapper;
	}

	private Component buildUserMenu() {
	    final MenuBar settings = new MenuBar();
	    settings.addStyleName("user-menu");
	    //final User user = getCurrentUser();
	    settingsItem = settings.addItem("abc",new ThemeResource("img/profile-pic-300px.jpg"), null);
	    //updateUserName(null);
	    settingsItem.addItem("Edit Profile", new Command() {
	        @Override
	        public void menuSelected(final MenuItem selectedItem) {
	            //ProfilePreferencesWindow.open(user, false);
	        }
	    });
	    settingsItem.addSeparator();
	    settingsItem.addItem("Sign Out", new Command() {
	        @Override
	        public void menuSelected(final MenuItem selectedItem) {
	            AuthService.logOut();
	        }
	    });
	    return settings;
	}
	

	private Component buildToggleButton() {
	    Button valoMenuToggleButton = new Button("Menu", new ClickListener() {
	        @Override
	        public void buttonClick(final ClickEvent event) {
	            if (getCompositionRoot().getStyleName()
	                    .contains(STYLE_VISIBLE)) {
	                getCompositionRoot().removeStyleName(STYLE_VISIBLE);
	            } else {
	                getCompositionRoot().addStyleName(STYLE_VISIBLE);
	            }
	        }
	    });
	    valoMenuToggleButton.setIcon(FontAwesome.LIST);
	    valoMenuToggleButton.addStyleName("valo-menu-toggle");
	    valoMenuToggleButton.addStyleName(ValoTheme.BUTTON_BORDERLESS);
	    valoMenuToggleButton.addStyleName(ValoTheme.BUTTON_SMALL);
	    return valoMenuToggleButton;
	}

	private Component buildMenuItems() {
	    CssLayout menuItemsLayout = new CssLayout();
	    menuItemsLayout.addStyleName("valo-menuitems");
	    
	    
	    for (final AppViewType view : AppViewType.values()) {
	    	if(view.isVisible()) {
		        Component menuItemComponent = new ValoMenuItemButton(view);
		        menuItemsLayout.addComponent(menuItemComponent);
	    	}
	    }
	    return menuItemsLayout;

	}
	
	
	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener(SideBarViewListener listener) {
		// TODO Auto-generated method stub
		
	}

}
