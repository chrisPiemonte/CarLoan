package main.ids.presentation.view.controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.ids.util.json.ViewsJsonParser;

public class GestionePassword {
	
	public GestionePassword(){
		
	}
	
	public void cambiaPassword(){
		try {
			ViewsJsonParser vjp = ViewsJsonParser.getInstance();
			String path = vjp.getViewPath("cambiaPass");
		    FXMLLoader loader = new FXMLLoader(getClass().getResource(path));  
		    Parent root = (Parent) loader.load();  
		    Scene scene = new Scene(root,600,500);  
		    Stage stage = new Stage();  
		    stage.setScene(scene);  
		    stage.setTitle("Apri Contratto");
		    stage.initModality(Modality.APPLICATION_MODAL);    
		    stage.show();  
			}catch (IOException | NullPointerException e) {
				
				e.printStackTrace();
				

			} 
	}

}
