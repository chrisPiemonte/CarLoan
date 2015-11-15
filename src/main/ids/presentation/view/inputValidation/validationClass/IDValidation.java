package main.ids.presentation.view.inputValidation.validationClass;

import java.util.regex.Pattern;

import main.ids.presentation.view.inputValidation.InputValidation;

public class IDValidation implements InputValidation{

	
	private String regex = "[a-zA-Z]";
	
	
	@Override
	public Boolean isValid(String string) {
			
		return Pattern.matches(regex, string);
	}
	

}