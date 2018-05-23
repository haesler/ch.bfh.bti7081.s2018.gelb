package ch.bfh.bti7081.s2018.yellow.health.ui.components.searchcontact;

import com.vaadin.data.ValueProvider;

import ch.bfh.bti7081.s2018.yellow.health.models.Contact;

public class SearchContactPresenter implements SearchContactView.SearchContactViewListener{

	SearchContactModel model;
	SearchContactViewImpl view;
	
	public SearchContactPresenter(SearchContactModel model,SearchContactViewImpl view) {
		this.model = model;
		this.view  = view;

		view.showContacts(model.contacts);
		view.addListener(this);
		view.grid.setDataProvider(model.dataProvider);
	}
	
	
	public void filter1(String text, ValueProvider<Contact, ?> valueProvider) {
		if (text != null) {
			model.dataProvider.setFilter(valueProvider, s -> caseInsensitiveContains(s.toString(), text));
    	  } else {
    		  model.dataProvider.clearFilters();
    	  }
	}
	
   private Boolean caseInsensitiveContains(String where, String what) {
        return where.toLowerCase().contains(what.toLowerCase());
    }

}
