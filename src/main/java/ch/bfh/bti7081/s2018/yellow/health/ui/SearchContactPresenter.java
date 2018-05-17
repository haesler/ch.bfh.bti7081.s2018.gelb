package ch.bfh.bti7081.s2018.yellow.health.ui;

public class SearchContactPresenter implements SearchContactView.SearchContactViewListener{

	SearchContactModel model;
	SearchContactView  view;
	SearchContactViewImpl layout;
	
	public SearchContactPresenter(SearchContactModel model,SearchContactView  view,
															SearchContactViewImpl layout) {
		this.model = model;
		this.view  = view;
		this.layout = layout;

		view.showContacts(model.contacts);
		view.addListener(this);
	}
	
	@Override
	public void buttonClick(String buttonName) {
		
		 switch (buttonName) {
	        case "clearNameFilterTextBtn":
	            view.clearText(layout.getNameFilterText());
	            break;
	        case "clearFirstnameFilterTextBtn":
	        		view.clearText(layout.getFirstnameFilterText());
	            break;
	        case "clearStreetFilterTextBtn":
	        		view.clearText(layout.getStreetFilterText());
	            break;
	        case "clearCityFilterTextBtn":
	        		view.clearText(layout.getCityFilterText());
	            break;
	        } 	
	}

	@Override
	public void valueChange(String txtFieldName, String value) {
		
		switch (txtFieldName) {
        case "nameFilterText":
            model.findLastname(value);
            view.showContacts(model.contacts);
            break;
        case "firstnameFilterText":
        		model.findFirstname(value);
            view.showContacts(model.contacts);
            break;
        case "streetFilterText":
        		model.findStreet(value);
            view.showContacts(model.contacts);
            break;
        case "cityFilterText":
        		model.findCity(value);
            view.showContacts(model.contacts);
            break;
        } 	
	}
}
