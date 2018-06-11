package ch.bfh.bti7081.s2018.yellow.health.ui.components.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vaadin.server.UserError;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;

import ch.bfh.bti7081.s2018.yellow.health.ui.components.patient.AddPatientView;

public class ContactValidate {
	
	
	public boolean isValid(TextField txt_FirstName, TextField txt_Name, TextField txt_Street, TextField txt_PLZ, TextField txt_City, TextField txt_Phone,
			TextField txt_Mobile, TextField txt_Mail, DateField df_Birthday) {
		boolean isValid = true;
		if(check_Name(txt_Name)!=true) isValid=false;
		if(check_Firstname(txt_FirstName)!=true) isValid=false;
		if(check_Street(txt_Street)!=true) isValid=false;
		if(check_PLZ(txt_PLZ)!=true) isValid=false;
		if(check_City(txt_City)!=true) isValid=false;
		if(check_Phone(txt_Phone)!=true)isValid=false;
		if(check_Mobile(txt_Mobile)!=true) isValid=false;
		if(check_Mail(txt_Mail)!=true) isValid=false;
		if(check_Birthday(df_Birthday)!=true) isValid=false;
		return isValid;
	}
	
	
	
	
	public boolean check_Firstname(TextField txt_FirstName){
		//IsEmpty
		if(txt_FirstName.getValue().isEmpty()){
			txt_FirstName.setComponentError(null);
	        txt_FirstName.setComponentError(new UserError("No Firstname entered"));
			return false;
		}
		//IsNumber
		try{
			Integer.parseInt(txt_FirstName.getValue());
			txt_FirstName.setComponentError(new UserError("No numbers accepted"));
			return false;
		}
		//IsString
		catch (NumberFormatException ex){
			txt_FirstName.setComponentError(null);
			return true;
		}
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
				txt_Name.setComponentError(null);
		        txt_Name.setComponentError(new UserError("No numbers accepted"));
				return false;
			}
			//IsString
			catch (NumberFormatException ex){
				txt_Name.setComponentError(null);
				return true;
			}
	}
	
	public boolean check_Street(TextField txt_Street){
		//IsEmpty
		if(txt_Street.getValue().isEmpty()){
			txt_Street.setComponentError(null);
			txt_Street.setComponentError(new UserError("No Street entered"));
			return false;
		}
		//IsNumber
		try{
			Integer.parseInt(txt_Street.getValue());
			txt_Street.setComponentError(null);
			txt_Street.setComponentError(new UserError("No numbers accepted"));
			return false;
		}
		//IsString
		catch (NumberFormatException ex){
			txt_Street.setComponentError(null);
			return true;
		}
	}
	
	public boolean check_PLZ(TextField txt_PLZ){
		//IsEmpty
		if(txt_PLZ.getValue().isEmpty()){
			txt_PLZ.setComponentError(null);
			txt_PLZ.setComponentError(new UserError("No PLZ entered"));
			return false;
		}
		//IsNumber
		try{
			Integer.parseInt(txt_PLZ.getValue());
			txt_PLZ.setComponentError(null);
			return true;
		}
		//IsString
		catch (NumberFormatException ex){
			txt_PLZ.setComponentError(null);
			txt_PLZ.setComponentError(new UserError("No numbers accepted"));
			return false;
		}
	}
	
	
	public boolean check_City(TextField txt_City){
		//IsEmpty
		if(txt_City.getValue().isEmpty()){
			txt_City.setComponentError(null);
			txt_City.setComponentError(new UserError("No City entered"));
			return false;
		}
		//IsNumber
		try{
			Integer.parseInt(txt_City.getValue());
			txt_City.setComponentError(null);
			txt_City.setComponentError(new UserError("No numbers accepted"));
			return false;
		}
		//IsString
		catch (NumberFormatException ex){
			txt_City.setComponentError(null);
			return true;
		}
	}
	
	public boolean check_Phone(TextField txt_Phone){
		//IsEmpty
		if(txt_Phone.getValue().isEmpty()){
			txt_Phone.setComponentError(null);
			txt_Phone.setComponentError(new UserError("No Phone entered"));
			return false;
		}
		//IsNumber
		try{
			Integer.parseInt(txt_Phone.getValue());
			txt_Phone.setComponentError(null);
			return true;
		}
		//IsString
		catch (NumberFormatException ex){
			txt_Phone.setComponentError(new UserError("Only numbers accepted"));
			return false;
		}
	}
	
	public boolean check_Mobile(TextField txt_Mobile){
		//IsEmpty
		if(txt_Mobile.getValue().isEmpty()){
			txt_Mobile.setComponentError(null);
			txt_Mobile.setComponentError(new UserError("No Mobile entered"));
			return false;
		}
		//IsNumber
		try{
			Integer.parseInt(txt_Mobile.getValue());
			txt_Mobile.setComponentError(null);
			return true;
		}
		//IsString
		catch (NumberFormatException ex){
			txt_Mobile.setComponentError(new UserError("Only numbers accepted"));
			return false;
		}
	}
	
	public boolean check_Mail(TextField txt_Mail){
		//IsEmpty
		if(txt_Mail.getValue().isEmpty()){
			txt_Mail.setComponentError(null);
			txt_Mail.setComponentError(new UserError("No Mail entered"));
			return false;
		}
		
		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(txt_Mail.getValue());
		if(matcher.find()){
			txt_Mail.setComponentError(null);
			return true;
		}
		else{
			txt_Mail.setComponentError(new UserError("Not a correct Mailaddress"));
			return false;
		}
		
	}
	
	public boolean check_Birthday(DateField df_Birthday){
		
		//IsEmpty
		if(df_Birthday.isEmpty()){
			df_Birthday.setComponentError(null);
			df_Birthday.setComponentError(new UserError("No Birthday entered"));
			return false;
		}
		df_Birthday.setComponentError(null);
		return true;
	}
}

