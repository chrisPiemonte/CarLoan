package main.ids.presentation.view.controller.gestioneCliente;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InserisciClientePopUp implements Initializable {
	
	public Button annulla;
	public Button conferma;
	public TextField cf;
	public TextField nome;
	public TextField cognome;
	public TextField telefono;
	public TextArea gg;
	public TextArea mm;
	public TextArea aa;
	
	
	
	@Override 
	public void initialize(URL location, ResourceBundle resources){
		
		//textField
		cf.setPromptText("inserisci codice fiscale...");
		cf.setFocusTraversable(false);
		nome.setPromptText("inserisci nome...");
		nome.setFocusTraversable(false);
		cognome.setPromptText("inserisci cognome...");
		cognome.setFocusTraversable(false);
		telefono.setPromptText("inserisci numero di telefono...");
		telefono.setFocusTraversable(false);
		gg.setFocusTraversable(false);
		mm.setFocusTraversable(false);
		aa.setFocusTraversable(false);

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
