package main.ids.presentation.view.inputValidation.validationClass;

import java.util.regex.Pattern;

import main.ids.presentation.view.inputValidation.InputValidation;

public class CodiceFiscaleValidation implements InputValidation{

	
	private String regex = "[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]";
	
	
	@Override
	public Boolean isValid(String string) {
			
		return Pattern.matches(regex, string);
	}
	

}
