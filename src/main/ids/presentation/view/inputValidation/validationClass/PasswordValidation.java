package main.ids.presentation.view.inputValidation.validationClass;

import main.ids.presentation.view.inputValidation.InputValidation;

public class PasswordValidation implements InputValidation{

	
	@Override
	public Boolean isValid(String string) {
		if (string.length() >= 20)
			return false;
		else
		return true;
		
	}

}
