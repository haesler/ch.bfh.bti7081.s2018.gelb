package ch.bfh.bti7081.s2018.yellow.health.ui.components.registration;

import com.vaadin.navigator.View;

public interface RegistrationView {
	
	interface RegistrationViewListener{
		void buttonClick();
	}
	
	public void addListener(RegistrationViewListener listener);
	void setNotification(String msg, String style);
	void hideNotification();
	void buttonClick();
	String getName();
	String getPassword1();
	String getPassword2();
}
