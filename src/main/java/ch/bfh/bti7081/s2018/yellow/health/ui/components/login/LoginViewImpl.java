package ch.bfh.bti7081.s2018.yellow.health.ui.components.login;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextAttributeEvent;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.LoginLayout;

public class LoginViewImpl extends VerticalLayout implements LoginView, ClickListener{
	
	//getBut_login().addClickListener(e -> loginViewListeners.forEach(l -> l.eventFired()));
	//addComponent(getBut_login());
	List<LoginViewListener> listeners = new ArrayList<LoginViewListener>();

	public LoginViewImpl(){
        setSizeFull();
        setMargin(false);
        setSpacing(false);
		loginForm = new LoginLayout();
		addComponent(loginForm);
		setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);
		loginForm.getBut_login().addClickListener(this);
	}

	private LoginLayout loginForm;
	
	@Override
	public void buttonClick(ClickEvent event) {
		for (LoginViewListener listener: listeners)
			listener.buttonClick();
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
	
}
