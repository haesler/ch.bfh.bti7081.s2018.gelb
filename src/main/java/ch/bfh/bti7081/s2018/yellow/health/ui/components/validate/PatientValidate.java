package ch.bfh.bti7081.s2018.yellow.health.ui.components.validate;

import com.vaadin.server.UserError;
import com.vaadin.ui.DateField;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;

import ch.bfh.bti7081.s2018.yellow.health.models.Doctor;
import ch.bfh.bti7081.s2018.yellow.health.models.Insurance;

public class PatientValidate {
	

	public boolean isValid(DateField df_Startdate, DateField df_Enddate, NativeSelect<Insurance> dd_Insurance, NativeSelect<Doctor> dd_Doctor) {
		boolean isValid = true;
		if(check_Startdate(df_Startdate)!=true) isValid=false;
		if(check_Enddate(df_Enddate)!=true) isValid=false;
		if(check_Insurance(dd_Insurance)!=true) isValid=false;
		if(check_Doctor(dd_Doctor)!=true) isValid=false;
		return isValid;
	}
	
	
public boolean check_Startdate(DateField df_Startdate){
		//IsEmpty
		if(df_Startdate.isEmpty()){
			df_Startdate.setComponentError(new UserError("No Startdate selected"));
			return false;
		}
		df_Startdate.setComponentError(null);
		return true;
	}

public boolean check_Enddate(DateField df_Enddate){
	//IsEmpty
	if(df_Enddate.isEmpty()){
		df_Enddate.setComponentError(new UserError("No Enddate selected"));
		return false;
	}
	df_Enddate.setComponentError(null);
	return true;
}

public boolean check_Insurance(NativeSelect<Insurance> dd_Insurance){
	//IsEmpty
	if(dd_Insurance.isEmpty()){
		dd_Insurance.setComponentError(new UserError("No Insurance selected"));
		return false;
	}
	dd_Insurance.setComponentError(null);
	return true;
}

public boolean check_Doctor(NativeSelect<Doctor> dd_Doctor){
	//IsEmpty
	if(dd_Doctor.isEmpty()){
		dd_Doctor.setComponentError(new UserError("No Insurance selected"));
		return false;
	}
	dd_Doctor.setComponentError(null);
	return true;
}
	
	
	
}