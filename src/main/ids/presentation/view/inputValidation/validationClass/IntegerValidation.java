package main.ids.presentation.view.inputValidation.validationClass;

import main.ids.presentation.view.inputValidation.InputValidation;

public class IntegerValidation implements InputValidation {

	@Override
	public Boolean isValid(String string) {
		
		boolean check;
        try {
            Integer.parseInt(string);
            check = true;
        } catch (NumberFormatException e) {
        	check = false;
        }
        return check;

	}

}
