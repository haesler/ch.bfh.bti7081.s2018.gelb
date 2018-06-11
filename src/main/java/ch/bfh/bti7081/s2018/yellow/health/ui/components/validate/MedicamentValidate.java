package ch.bfh.bti7081.s2018.yellow.health.ui.components.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vaadin.server.UserError;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

import ch.bfh.bti7081.s2018.yellow.health.ui.components.patient.AddPatientView;

public class MedicamentValidate {
	
	
	public boolean isValid(TextField txt_Name, TextArea txt_Description) {
		boolean isValid = true;
		if(check_Name(txt_Name)!=true) isValid=false;
		if(check_Description(txt_Description)!=true) isValid=false;
		return isValid;
	}
	
	public boolean check_Name(TextField txt_Name){
		//IsEmpty
		if(txt_Name.getValue().isEmpty()){
			txt_Name.setComponentError(null);
			txt_Name.setComponentError(new UserError("No Name entered"));
			return false;
		}
		//IsNumber
		try{
			Integer.parseInt(txt_Name.getValue());
			txt_Name.setComponentError(new UserError("No numbers accepted"));
			return false;
		}
		//IsString
		catch (NumberFormatException ex){
			txt_Name.setComponentError(null);
			return true;
		}
	}
	
	public boolean check_Description(TextArea txt_Description){
			//IsEmpty
			if(txt_Description.getValue().isEmpty()){
				txt_Description.setComponentError(null);
				txt_Description.setComponentError(new UserError("No Description entered"));
				return false;
			}
			//IsNumber
			try{
				Integer.parseInt(txt_Description.getValue());
				txt_Description.setComponentError(null);
				txt_Description.setComponentError(new UserError("No numbers accepted"));
				return false;
			}
			//IsString
			catch (NumberFormatException ex){
				txt_Description.setComponentError(null);
				return true;
			}
	}
}

