package main.ids.presentation.view.manager.controller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InserisciFasciaPopUp implements Initializable {
	
	public Button annulla;
	public Button conferma;
	public TextField id;
	public TextField descrizione;
	public TextField tariffaGiornaliera;
	public TextField tariffaSettimanale;
	public TextField tariffakm;
	
	
	
	@Override 
	public void initialize(URL location, ResourceBundle resources){
		
		//textField
		id.setPromptText("inserisci identificativo...");
		id.setFocusTraversable(false);
		descrizione.setPromptText("inserisci descrizione...");
		descrizione.setFocusTraversable(false);
		tariffaGiornaliera.setPromptText("tariffa giornaliera...");
		tariffaGiornaliera.setFocusTraversable(false);
		tariffaSettimanale.setPromptText("tariffa settimanale...");
		tariffaSettimanale.setFocusTraversable(false);
		tariffakm.setPromptText("tariffa per chilometri...");
		tariffakm.setFocusTraversable(false);
		
		//bottoni
		annulla.setOnAction(e -> buttonClose());
		
	}
	
	
	public void buttonClose(){
		Stage stage = (Stage) annulla.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
	
	public boolean buttonConfirm(){
		return true;
	}

}
