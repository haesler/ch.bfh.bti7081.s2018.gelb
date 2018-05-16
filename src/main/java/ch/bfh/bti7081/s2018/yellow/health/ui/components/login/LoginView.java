package ch.bfh.bti7081.s2018.yellow.health.ui.components.login;

public interface LoginView {
	
	interface LoginViewListener{

		void buttonClick();
		
	}
	public void addListener(LoginViewListener listener);
	void buttonClick();
	void setNotification(String value);
	String getUsername();
	String getPassword();

}
