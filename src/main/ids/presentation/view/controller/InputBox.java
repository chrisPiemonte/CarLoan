package main.ids.presentation.view.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import main.ids.presentation.view.inputValidation.InputValidation;
import main.ids.presentation.view.inputValidation.InputValidationFactory;

public class InputBox {
	
	final static String [] arrayData = {"Disponibile", "Non-disponibile", "Manutenzione"};
	static List<String> dialogData;
	
	InputBox instance = new InputBox();
	
	
	public InputBox() {
		
	}
	
	public static String display(String title){
		
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("");
		dialog.setHeaderText(title); 
		Optional<String> result = dialog.showAndWait();
		String entered = "none.";
		 
		if (result.isPresent()) {
		 
		    entered = result.get();
		    InputValidation i = InputValidationFactory.getValidation("double");
		    if(i.isValid(entered)){
		    return result.get().toString();
		    }else { 
		    	Message.display("Chilometraggio non valido", AlertType.ERROR);
				return "null";
		    }
		}
		else 
			return "null";
		
		
	}
	
	public static String displayStato(String title){
		
		
		dialogData = Arrays.asList(arrayData);
			 
		ChoiceDialog dialog = new ChoiceDialog(dialogData.get(0), dialogData);
		dialog.setTitle(title);
		dialog.setHeaderText("Seleziona uno stato");
			 
		Optional<String> result = dialog.showAndWait();
		String selected = "cancelled.";
			         
		if (result.isPresent()) {
			 
			    switch(result.get().toString()){
			    	
			    	case "Disponibile":
			    		return "D";
			    	case "Non-disponibile":
			    		return "N";
			    	case "Manutenzione":
			    		return "M";
			    }
		}  
		
		return "null";
		
		
		
	}
}
