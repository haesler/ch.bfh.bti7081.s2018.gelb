package ch.bfh.bti7081.s2018.yellow.health.ui.components.login;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.UI;
import com.vaadin.ui.declarative.Design;

import ch.bfh.bti7081.s2018.yellow.health.repo.UserRepository;
import ch.bfh.bti7081.s2018.yellow.health.ui.MyUI;
import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.LoginLayout;


@SuppressWarnings("serial")
public class LoginPresenter implements LoginView.LoginViewListener {
	LoginLayout model;
    LoginView  view;


	public LoginPresenter(LoginLayout model, LoginView  view){
		this.model = model;
        this.view  = view;

        view.addListener(this);
		
	}
	
	public void buttonClick(){
		if (AuthService.login(view.getUsername(), view.getPassword()))
		{
			view.setNotification("success");
			((MyUI)UI.getCurrent()).isAuthenticated=true;
		    ((MyUI)UI.getCurrent()).updateContent();
		} else {
				view.setNotification("Login failed");
				           
		}     
		
	}
	
	
	


}
