package main.ids.presentation.view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InserisciAutoPopUp implements Initializable {
	
	public Button annulla;
	public Button conferma;
	public TextField targa;
	public TextField modello;
	public TextField stato;
	public TextField fascia;
	public TextField chilometraggio;
	public TextField agenzia;
	public TextArea gg;
	public TextArea mm;
	public TextArea aa;
	
	
	
	@Override 
	public void initialize(URL location, ResourceBundle resources){
		
		targa.setPromptText("inserisci targa...");
		targa.setFocusTraversable(false);
		modello.setPromptText("inserisci modello...");
		modello.setFocusTraversable(false);
		stato.setPromptText("inserisci stato...");
		stato.setFocusTraversable(false);
		fascia.setPromptText("inserisci fascia...");
		fascia.setFocusTraversable(false);
		chilometraggio.setPromptText("inserisci chilometraggio...");
		chilometraggio.setFocusTraversable(false);
		agenzia.setPromptText("inserisci agenzia...");
		agenzia.setFocusTraversable(false);
		annulla.setOnAction(e -> buttonClose());
		gg.setFocusTraversable(false);
		mm.setFocusTraversable(false);
		aa.setFocusTraversable(false);

		
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
