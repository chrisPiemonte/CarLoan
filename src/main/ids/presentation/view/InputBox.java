package main.ids.presentation.view;

import java.util.Optional;

import javafx.scene.control.TextInputDialog;

public class InputBox {
	
	private InputBox instance = new InputBox();
	
	public InputBox(){
		
	}

	public static String display(){
		
	
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Cambia");
		dialog.setHeaderText("Enter some text, or use default value.");
		 
		Optional<String> result = dialog.showAndWait();
		String entered = "none.";
		 
		if (result.isPresent()) {
		 
		    entered = result.get();
		    return entered;
		}
	

		return "not";
	}

}