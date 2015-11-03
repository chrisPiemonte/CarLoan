package main.ids.presentation.view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class Bootstrap implements Initializable {
	
	public TextField usernameInput;
	public TextField passwordInput;
	
	@Override 
	public void initialize(URL location, ResourceBundle resources){
		System.out.println("Loading user data...");
	}
	

	public void onClick(){
		
		System.out.println(usernameInput.getText());
		System.out.println(passwordInput.getText());
	}
	

}
