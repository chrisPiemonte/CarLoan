package main.ids.presentation.view.admin.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PopupAuto implements Initializable {
	
	public Button annulla;
	public Button conferma;
	
	
	@Override 
	public void initialize(URL location, ResourceBundle resources){
		
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
