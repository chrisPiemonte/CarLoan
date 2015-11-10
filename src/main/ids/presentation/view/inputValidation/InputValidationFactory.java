package main.ids.presentation.view.inputValidation;

import main.ids.presentation.view.inputValidation.validationClass.*;

public final class InputValidationFactory {
	
	public InputValidationFactory instance = new InputValidationFactory();
	
	
	private InputValidationFactory(){
		
	}
	
	
	public static InputValidation getValidation(String tipo){
		switch (tipo){
			case "password":
				return new PasswordValidation();
				
				
				
		}
		return null;
	}

}
