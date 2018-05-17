package ch.bfh.bti7081.s2018.yellow.health.ui;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Binder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;

import ch.bfh.bti7081.s2018.yellow.health.models.*;
import ch.bfh.bti7081.s2018.yellow.health.repo.UserRepository;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */

@Theme("mytheme")
public class ExampleDBAccess extends UI {

   @Autowired
   UserRepository repo;
   
   private User user;
   private Binder<User> binder = new Binder<>(User.class);
   private Grid<User> grid = new Grid(User.class);
   
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	updateGrid();
		grid.setColumns("username");
    
        setContent(grid);
    }
    
    private void updateGrid() {
        List<User> users = repo.findAll();
        grid.setItems(users);
    }


    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = ExampleDBAccess.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
