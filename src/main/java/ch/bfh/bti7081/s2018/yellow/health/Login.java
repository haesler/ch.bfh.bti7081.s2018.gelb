package ch.bfh.bti7081.s2018.yellow.health;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.navigator.View;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.declarative.Design;
import Check.CheckLogin;

/** 
 * !! DO NOT EDIT THIS FILE !!
 * 
 * This class is generated by Vaadin Designer and will be overwritten.
 * 
 * Please make a subclass with logic and additional interfaces as needed,
 * e.g class LoginView extends LoginDesign implements View { }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class Login extends AbsoluteLayout implements View {
	private Label lbl_Username;
	public Button but_login;
	private Label lbl_Password;
	private TextField txt_Username;
	private PasswordField txt_Password;
	private Label lbl_Test;


	
	public Login() {
		Design.read(this);
		
		but_login.addClickListener(new ClickListener(){
			
			public void buttonClick(ClickEvent event) {
				lbl_Test.setValue(txt_Username.getValue()+" "+txt_Password.getValue());
			}
		});
	}

	public Label getLbl_Username() {
		return lbl_Username;
	}

	public Button getBut_login() {
		return but_login;
	}

	public Label getLbl_Password() {
		return lbl_Password;
	}

	public TextField getTxt_Username() {
		return txt_Username;
	}

	public PasswordField getTxt_Password() {
		return txt_Password;
	}

	public Label getLbl_Test() {
		return lbl_Test;
	}


}
