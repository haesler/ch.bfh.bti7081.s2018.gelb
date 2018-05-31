package ch.bfh.bti7081.s2018.yellow.health.ui.components.login;

public interface LoginView {
	
	interface LoginViewListener{

		void but_loginClick();
		void but_registerClick();

		
	}
	public void addListener(LoginViewListener listener);
	void but_loginClick();
	void but_registerClick();
	void setNotification(String value);
	String getUsername();
	String getPassword();

}
