package ch.bfh.bti7081.s2018.yellow.health.ui.layouts;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.declarative.Design;

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
public class AddContactLayout extends AbsoluteLayout {
	private Label lbl_Message;
	private Label lbl_Name;
	private TextField txt_Name;
	private Label lbl_FirstName;
	private TextField txt_FirstName;
	private Label lbl_Street;
	private TextField txt_Street;
	private Label lbl_PLZ;
	private TextField txt_PLZ;
	private Label lbl_City;
	private TextField txt_City;
	private Label lbl_Phone;
	private TextField txt_Phone;
	private Label lbl_Mobile;
	private TextField txt_Mobile;
	private Label lbl_Mail;
	private TextField txt_Mail;
	private Label lbl_Birthday;
	private DateField df_Birhday;
	private Button but_Save;
	private Button but_Close;

	public AddContactLayout() {
		Design.read(this);
	}

	public Label getLbl_Message() {
		return lbl_Message;
	}

	public Label getLbl_Name() {
		return lbl_Name;
	}

	public TextField getTxt_Name() {
		return txt_Name;
	}

	public Label getLbl_FirstName() {
		return lbl_FirstName;
	}

	public TextField getTxt_FirstName() {
		return txt_FirstName;
	}

	public Label getLbl_Street() {
		return lbl_Street;
	}

	public TextField getTxt_Street() {
		return txt_Street;
	}

	public Label getLbl_PLZ() {
		return lbl_PLZ;
	}

	public TextField getTxt_PLZ() {
		return txt_PLZ;
	}

	public Label getLbl_City() {
		return lbl_City;
	}

	public TextField getTxt_City() {
		return txt_City;
	}

	public Label getLbl_Phone() {
		return lbl_Phone;
	}

	public TextField getTxt_Phone() {
		return txt_Phone;
	}

	public Label getLbl_Mobile() {
		return lbl_Mobile;
	}

	public TextField getTxt_Mobile() {
		return txt_Mobile;
	}

	public Label getLbl_Mail() {
		return lbl_Mail;
	}

	public TextField getTxt_Mail() {
		return txt_Mail;
	}

	public Label getLbl_Birthday() {
		return lbl_Birthday;
	}

	public DateField getDf_Birhday() {
		return df_Birhday;
	}

	public Button getBut_Save() {
		return but_Save;
	}

	public Button getBut_Close() {
		return but_Close;
	}
}
