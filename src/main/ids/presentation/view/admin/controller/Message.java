package main.ids.presentation.view.manager.controller;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;


public class Message {
	
	private Message instance = new Message();
	
	private Message() {
		
	}
	
	public static boolean display(String text, AlertType type){
		boolean check = false ;
		Alert alert = new Alert(type);
		alert.setHeaderText(text);
		alert.showAndWait();
		if (alert.getResult() == ButtonType.OK){
			return true;
		}
		else return false;
	}
	

}


