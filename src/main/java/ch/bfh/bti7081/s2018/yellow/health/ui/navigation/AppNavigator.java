package ch.bfh.bti7081.s2018.yellow.health.ui.navigation;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class AppNavigator extends Navigator {

	    public AppNavigator(ComponentContainer container) {
	        super(UI.getCurrent(), container);
	    }
	    
	    public void initViews() {
	    	for (final AppViewType viewType : AppViewType.values()) {
	    		//this.addView(viewType.getViewName(), viewType.getViewClass());
	    	}
	    }
}
