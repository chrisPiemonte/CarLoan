package main.ids.presentation.view.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import main.ids.presentation.FrontController;
import main.ids.presentation.response.Response;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CredenzialiErrate implements Initializable {
	
	public Button button;
	FrontController frontController = new FrontController();
	ArrayList<String> parameter = new ArrayList<String>();
	
	@Override 
	public void initialize(URL location, ResourceBundle resources){
		System.out.println("Loading user data...");
		
		button.setOnAction(e -> onClick());
	}
	

	public void onClick(){
		
		
		ComplexRequest request = new ComplexRequest();
		parameter.add("errore");
		request.setRequest("credenzialiErrate");
		frontController.processRequest(request);
		
		
	}
	

}
