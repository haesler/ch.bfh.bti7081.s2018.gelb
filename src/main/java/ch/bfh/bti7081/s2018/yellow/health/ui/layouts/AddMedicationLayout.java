package ch.bfh.bti7081.s2018.yellow.health.ui.layouts;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
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
public class AddMedicationLayout extends AbsoluteLayout {
	private TextField txt_usage;
	private Label lbl_DateStart;
	private DateField df_StartDate;
	private Label lbl_EndDate;
	private DateField df_EndDate;
	private Label lbl_active;
	private CheckBox ckb_active;
	private Button bu_save;
	private Label lbl_Message;

	public AddMedicationLayout() {
		Design.read(this);
	}

	public TextField getTxt_usage() {
		return txt_usage;
	}

	public Label getLbl_DateStart() {
		return lbl_DateStart;
	}

	public DateField getDf_StartDate() {
		return df_StartDate;
	}

	public Label getLbl_EndDate() {
		return lbl_EndDate;
	}

	public DateField getDf_EndDate() {
		return df_EndDate;
	}

	public Label getLbl_active() {
		return lbl_active;
	}

	public CheckBox getCkb_active() {
		return ckb_active;
	}

	public Button getBu_save() {
		return bu_save;
	}

	public Label getLbl_Message() {
		return lbl_Message;
	}
}
