package ch.bfh.bti7081.s2018.yellow.health.ui;

import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import ch.bfh.bti7081.s2018.yellow.health.models.User;
import ch.bfh.bti7081.s2018.yellow.health.repo.UserRepository;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.login.LoginPresenter;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.login.LoginViewImpl;
import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.LoginLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */

@SpringUI 
@Theme("mytheme")
public class MyUI extends UI {
	
    @Autowired
    UserRepository repo;

    public boolean isAuthenticated = false;
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	if (isAuthenticated!=true){
    		// Create the model and the Vaadin view implementation
    		LoginLayout model = new LoginLayout();
    		LoginViewImpl view  = new LoginViewImpl();

    		// The presenter binds the model and view together
    		new LoginPresenter(model,view);
    		setContent(view);
    	}
    	else{
    		
    		setContent(new MainView());
    	}
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
