package ch.bfh.bti7081.s2018.yellow.health.ui.components.registration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.bti7081.s2018.yellow.health.ui.components.tabcontrol.TabPresenter;
import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.RegistrationLayout;

@Service
public class RegistrationViewImpl extends VerticalLayout implements RegistrationView {

	List<RegistrationViewListener> listeners = new ArrayList<RegistrationViewListener>();
	private RegistrationPresenter presenter;
	private RegistrationLayout RegistrationForm;
	
	private static RegistrationViewImpl repo;
	
	@Autowired
	public RegistrationViewImpl() {
		setSizeFull();
		RegistrationViewImpl.repo = repo;
		RegistrationForm = new RegistrationLayout();
		RegistrationForm.getBtn_Submit().addClickListener(e -> this.buttonClick());
		addComponent(RegistrationForm);
		setComponentAlignment(RegistrationForm, Alignment.MIDDLE_CENTER);
	}
	
	@Override
	public void addListener(RegistrationViewListener listener) {
		listeners.add(listener);
	}

	public void setNotification(String msg, String style) {
		System.out.println("Set notification");
		RegistrationForm.getLbl_Error().setValue(msg);
		RegistrationForm.getLbl_Error().setStyleName(style);
		RegistrationForm.getLbl_Error().setVisible(true);
	}
	
	public void hideNotification() {
		if(RegistrationForm.getLbl_Error().isVisible()) {
			RegistrationForm.getLbl_Error().setVisible(false);
		}
	}
	
	public RegistrationPresenter getPresenter() {
		return presenter;
	}

	@Override
	public void buttonClick() {
		for (RegistrationViewListener listener: listeners)
			listener.buttonClick();
	}

	@Override
	public String getName() {
		return RegistrationForm.getTxt_Name().getValue();
	}

	@Override
	public String getPassword1() {
		return RegistrationForm.getPwd_Password1().getValue();
				
	}

	@Override
	public String getPassword2() {
		return RegistrationForm.getPwd_Password2().getValue();
	}
	
	@Override
	public void setName(String name) {
		RegistrationForm.getLbl_Name().setValue(name);
	}
	
	@Override
	public void setPassword1(String password) {
		RegistrationForm.getPwd_Password1().setValue(password);
	}

}
