package main.ids.presentation.view.inputValidation;

/**
 * classe per la validazione degli input inseriti nelle interfacce.
 * Utilizza {@link InputValidatioFactory} per generare i parametri 
 * di validazione, differenziati in base al tipo di input
 * @author bi
 *
 */

public interface InputValidation {
	
	public Boolean isValid(String string);

}
