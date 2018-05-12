package ch.bfh.bti7081.s2018.yellow.health.ui;

import com.vaadin.navigator.*;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
public class LoginView  extends Login{
	//public void enter(ViewChangeEvent event) {
	public LoginView() {
		getBut_login().addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
		
				if(getTxt_Username().getValue() == "demo" && getTxt_Password().getValue() == "demo" )
				{
				       getLbl_Notification().setValue("success");
				       //öffnen von Mainview...
				} else {
				       getLbl_Notification().setValue("Login failed");
				       getTxt_Username().focus();
				                        
				}          
			}
		}); 
	}
}



