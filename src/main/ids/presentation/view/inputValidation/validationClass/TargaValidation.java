package main.ids.presentation.view.inputValidation.validationClass;

import java.util.regex.Pattern;

import main.ids.presentation.view.inputValidation.InputValidation;

public class TargaValidation implements InputValidation {

	private String regex = "[a-zA-Z //s]{2,3}[0-9 //s]{3,4}[a-zA-Z //s]{2,3}";
	@Override
	public Boolean isValid(String string) {
		return Pattern.matches(regex, string);
	}
	
	
	public static void main (String [] args){
		TargaValidation t = new TargaValidation();
		System.out.println(t.isValid("tf456re"));
	}

}
