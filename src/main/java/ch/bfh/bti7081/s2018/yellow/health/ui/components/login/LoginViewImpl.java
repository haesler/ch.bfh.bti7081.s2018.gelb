package ch.bfh.bti7081.s2018.yellow.health.ui.components.login;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextAttributeEvent;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutListener;
import com.vaadin.ui.Alignment;

import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.LoginLayout;

@SuppressWarnings("serial")
public class LoginViewImpl extends VerticalLayout implements LoginView{
	
	//getBut_login().addClickListener(e -> loginViewListeners.forEach(l -> l.eventFired()));
	//addComponent(getBut_login());
	List<LoginViewListener> listeners = new ArrayList<LoginViewListener>();

	public LoginViewImpl(){
		setSizeFull();
        setMargin(false);
        setSpacing(false);
		loginForm = new LoginLayout();
		loginForm.getBut_login().addClickListener(e -> this.but_loginClick());
		loginForm.getBut_login().setClickShortcut(KeyCode.ENTER);
		loginForm.getBut_register1().addClickListener(e -> this.but_registerClick());
		addComponent(loginForm);
		setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);
		//loginForm.getBut_login().addClickListener(this);
		
	}

	private LoginLayout loginForm;

	@Override
	public void but_registerClick() {
		for (LoginViewListener listener: listeners)
			listener.but_registerClick();
	}
	@Override
	public void but_loginClick() {
			for (LoginViewListener listener: listeners)
			listener.but_loginClick();
	}

	@Override
	public void addListener(LoginViewListener listener) {
		listeners.add(listener);
	}
	
	public String getUsername(){
		return loginForm.getTxt_Username().getValue();
	}
	
	public String getPassword(){
		return loginForm.getTxt_Password().getValue();
	}
	
	public void setNotification(String value){
		loginForm.getLbl_Notification().setValue(value);
	}


	
	
}
