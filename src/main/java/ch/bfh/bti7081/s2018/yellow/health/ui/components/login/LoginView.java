package ch.bfh.bti7081.s2018.yellow.health.ui.components.login;

public interface LoginView {
	
	interface LoginViewListener{

		void buttonClick(char charAt);
		
	}
	public void addListener(LoginViewListener listener);

}
