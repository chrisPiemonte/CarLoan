package main.ids.presentation.view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import main.ids.presentation.FrontController;
import main.ids.presentation.request.BasicRequest;

public class Warning implements Initializable {
	
	public Label message;
	public Button ok;
	Stage stage;
	
	@Override 
	public void initialize(URL location, ResourceBundle resources){
		
		message.setText("Credenziali errate!");
		ok.setOnAction(e -> buttonClose());
		
	}
	
	
	public void buttonClose(){
		
		Stage stage = (Stage) ok.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
	
	

}
