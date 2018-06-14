package ch.bfh.bti7081.s2018.yellow.health.ui.components.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaadin.sass.internal.parser.ParseException;
import com.vaadin.ui.UI;

import ch.bfh.bti7081.s2018.yellow.health.models.User;
import ch.bfh.bti7081.s2018.yellow.health.repo.UserRepository;
import ch.bfh.bti7081.s2018.yellow.health.ui.MyUI;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.login.LoginView;
import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.LoginLayout;
import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.RegistrationLayout;
import ch.bfh.bti7081.s2018.yellow.health.util.UserService;

@SuppressWarnings("serial")
public class RegistrationPresenter implements RegistrationView.RegistrationViewListener {
	
	RegistrationLayout model;
	RegistrationView view;
	User user = new User();
	private static UserRepository repo;
	
	public RegistrationPresenter(RegistrationLayout model, RegistrationView  view, UserRepository repo){
		this.model = model;
        this.view  = view;
        RegistrationPresenter.repo = repo;

        view.addListener(this);
	}
	
	@Override
	public void buttonClick() {
		//Make Notification invisible if visible
		view.hideNotification();
		
		//Check: empty Password
		System.out.println("Check empty password: " + view.getPassword1());
		if(view.getPassword1().length() == 0) {
			System.out.println("Error: Missing Password.");
			view.setNotification("The password is missing.", "failure");
			return;
		}
		
		//Check: Passwords the same
		System.out.println("Check passwords");
		if(!view.getPassword1().equals(view.getPassword2())) {
			System.out.println("Error: Passwords different.");
			view.setNotification("The passwords aren't the same.", "failure");
			return;
		}
		
		//Check: Unique username
		System.out.println("Check username: " + view.getName());
		if(view.getName().equals(repo.checkUsername(view.getName()))) {
			System.out.println("Error: Username already exists.");
			view.setNotification("This username is already in use.", "failure");
			return;
		}
		
		//Save user
		user.createUser(view.getName(), view.getPassword1());
		repo.save(user);
		System.out.println("User saved");
		
		//Switch to login
		view.setNotification("User created", "success");
		((MyUI)UI.getCurrent()).updateContent();
	}
	
	public void loadRegister() {
		user.createUser(UserService.getUserName(), UserService.getPassword());
	
		view.setName(user.getUsername());
		view.setPassword1(user.getPassword());
	}

}
