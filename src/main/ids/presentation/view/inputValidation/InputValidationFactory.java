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
	            
			case "nome":
				return new NomeValidation();
	        
			case "cognome":
				return new CognomeValidation();
			case "intero":
				return new IntegerValidation();

			case "double":
				return new DoubleValidation();
				
			case "telefono":
				return new PhoneValidation();
				
			case "targa":
				return new TargaValidation();
				
			case "cf" :
				return new CodiceFiscaleValidation();
	         default:
	        	 return null;
		}
				
				
		
		
	}

}
