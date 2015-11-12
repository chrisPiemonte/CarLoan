package main.ids.presentation.view.inputValidation.validationClass;

import java.util.regex.Pattern;

import main.ids.presentation.view.inputValidation.InputValidation;

public class PhoneValidation implements InputValidation {

	private String regex = "[0-9]{2,20}";
	@Override 
	public Boolean isValid(String string) {
		return Pattern.matches(regex, string);
	}
	
	

}
