package main.ids.presentation.view.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import main.ids.presentation.DefaultFrontController;
import main.ids.presentation.FrontController;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.presentation.view.inputValidation.InputValidation;
import main.ids.presentation.view.inputValidation.InputValidationFactory;
import main.ids.transferObjects.ImpiegatoTO;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.request.RequestType;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Bootstrap implements Initializable {
	
	public TextField usernameInput;
	public PasswordField passwordInput;
	public ArrayList<String> data ;
	public ComplexResponse response;
	
	FrontController frontController;
	
	@Override 
	public void initialize(URL location, ResourceBundle resources){
		
	}
	

	public void onClick(){
		frontController = new DefaultFrontController();
		boolean isValidInput = login(usernameInput.getText().toString(),passwordInput.getText().toString());
		if (!isValidInput){
			System.out.println("OOH");
			
			clean();
		}
			
		
		
		
			
	}		
	
	public boolean checkInput(String username, String password){
		if ((username.isEmpty() || password.isEmpty())){
			Message.display("Campi vuoti", AlertType.ERROR);
			return false;
		} else {
			InputValidation passwordValidation = InputValidationFactory.getValidation("password");
			if(!passwordValidation.isValid(password)){
				Message.display("Password troppo lunga", AlertType.ERROR);
				return false;
			} else return true;
			
			
			
		}
	}
	
	
	public boolean login(String username, String password){
		if(checkInput(username,password)){
			ComplexRequest<String> request = new ComplexRequest<String>();
			data = new ArrayList<String>();
			data.add(username);
			data.add(password);
			request.setRequest("login");
			request.setParameters(data);
			request.setType(RequestType.SERVICE);
			response = (ComplexResponse<ImpiegatoTO>)frontController.processRequest(request);
			System.out.println(response.isResponse());
				if (!response.isResponse()){
					Message.display("Credenziali errate", AlertType.ERROR);
					return false;
				} else {
					return true;
				}
		} else {
		return false;
		}
	}
	
	public void clean(){
		usernameInput.clear();
		passwordInput.clear();
	}
		
		
		
	
	

}
