package ch.bfh.bti7081.s2018.yellow.health.ui.navigation;

import org.springframework.context.ApplicationContext;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewProvider;
import com.vaadin.navigator.Navigator.ClassBasedViewProvider;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class AppNavigator extends Navigator {

		private ApplicationContext context;
		
	    public AppNavigator(ComponentContainer container, ApplicationContext context) {
	        super(UI.getCurrent(), container);
	    	this.context = context;
	    	initViews();
	    }
	    
	    public void initViews() {
	    	for (final AppViewType viewType : AppViewType.values()) {
	    			//initialize views
					this.addView(viewType.getViewName(), context.getBean(viewType.getViewClass()));
	    	}
	    }
}
