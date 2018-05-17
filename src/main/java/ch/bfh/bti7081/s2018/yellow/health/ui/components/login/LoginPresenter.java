package ch.bfh.bti7081.s2018.yellow.health.ui.components.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.UI;
import com.vaadin.ui.declarative.Design;

import ch.bfh.bti7081.s2018.yellow.health.models.User;
import ch.bfh.bti7081.s2018.yellow.health.repo.UserRepository;
import ch.bfh.bti7081.s2018.yellow.health.ui.MyUI;
import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.LoginLayout;

@SuppressWarnings("serial")
public class LoginPresenter implements LoginView.LoginViewListener {
	LoginLayout model;
    LoginView  view;
    @Autowired
    UserRepository repo;


	public LoginPresenter(LoginLayout model, LoginView  view,  UserRepository repo){
		this.model = model;
        this.view  = view;

        view.addListener(this);
		
	}
	
	public void buttonClick(){
		
		String pw = repo.findPassword(view.getUsername());
		
		if( view.getPassword().equals(pw))
		{
			view.setNotification("success");
			((MyUI)UI.getCurrent()).isAuthenticated=true;
		       //öffnen von Mainview...
		} else {
				view.setNotification("Login failed");

		                        
		}     
		
	}
	
	
	


}
