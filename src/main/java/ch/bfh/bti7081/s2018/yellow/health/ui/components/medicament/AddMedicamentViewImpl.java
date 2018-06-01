package ch.bfh.bti7081.s2018.yellow.health.ui.components.medicament;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;

import ch.bfh.bti7081.s2018.yellow.health.models.Medicament;
import ch.bfh.bti7081.s2018.yellow.health.repo.MedicamentRepository;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.searchcontact.SearchContactModel;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.searchcontact.SearchContactPresenter;
import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.AddMedicamentLayout;

@Component
public class AddMedicamentViewImpl extends AbsoluteLayout implements AddMedicamentView {

	private static final long serialVersionUID = 1L;
	
	List<AddMedicamentViewListener> listeners = new ArrayList<AddMedicamentViewListener>();
	private AddMedicamentPresenter presenter;
	private AddMedicamentLayout layout;
	

	
	@Autowired
	public AddMedicamentViewImpl(AddMedicamentModel service){
		
		layout = new AddMedicamentLayout();
        layout.getBu_save().addClickListener(e -> this.buttonClick());
        addComponent(layout);
		
		this.presenter = new AddMedicamentPresenter(service,this);
		//this.presenter = new AddMedicamentPresenter(service, this); 
	}
	
	@Override
	public void buttonClick() {
		for (AddMedicamentViewListener listener: listeners)
			listener.buttonClick();
	}
	
	@Override
	public void addListener(AddMedicamentViewListener listener) {
		listeners.add(listener);
	}

	
	public void setNotification(){
		layout.getLbl_Message().setVisible(true);
	}
	
	public boolean check(){
		if(this.getMedicamentName()!=""){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public String getMedicamentName() {
		return layout.getTxt_Name().getValue();
	}

	@Override
	public String getMedicamentDescription() {
		return layout.getTxt_Description().getValue();
	}
	
	@Override
	public Grid<Medicament> getGrid() {
		return layout.getGr_Medicaments();
	}
	
	@Override
	public Button getSaveButton() {
		return layout.getBu_save();
	}

	@Override
	public void showMedicaments(List<Medicament> medicaments) {
		
		
	}
}
