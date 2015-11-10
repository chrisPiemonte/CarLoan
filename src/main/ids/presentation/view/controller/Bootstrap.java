package main.ids.presentation.view.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import main.ids.presentation.FrontController;
import main.ids.presentation.response.Response;
import main.ids.presentation.view.inputValidation.InputValidation;
import main.ids.presentation.view.inputValidation.InputValidationFactory;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.request.RequestType;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Bootstrap implements Initializable {
	
	public TextField usernameInput;
	public PasswordField passwordInput;
	public ArrayList<String> data = new ArrayList<String>();
	public Response response;
	
	FrontController frontController;
	
	@Override 
	public void initialize(URL location, ResourceBundle resources){
		frontController = new FrontController();
	}
	

	public void onClick(){
		
	if (checkInput(usernameInput.getText().toString(),passwordInput.getText().toString())){; 
		ComplexRequest<String> request = new ComplexRequest<String>();
		data.add(usernameInput.getText().toString());
		data.add(passwordInput.getText().toString());
		System.out.println(usernameInput.getText().toString() + " " + passwordInput.getText().toString());
		request.setRequest("login");
		request.setParameters(data);
		request.setType(RequestType.SERVICE);
		response = frontController.processRequest(request);
		if (!response.isResponse()) {
			usernameInput.clear();
            passwordInput.clear();
			try {
			    FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/ids/presentation/view/Warning.fxml"));  
			    Parent root = (Parent) loader.load();  
			    Scene scene = new Scene(root,400,400);  
			    Stage stage = new Stage();  
			    stage.setScene(scene);  
			    stage.setTitle("Attenzione");
			    stage.initModality(Modality.APPLICATION_MODAL);    
			    stage.show();  
				}catch (IOException | NullPointerException e) {
					
					e.printStackTrace();
					

				}
			
			}
		} else { System.out.println("Cia");}
	}
	
	
	public boolean checkInput(String username, String password){
		if ((username.isEmpty() || password.isEmpty())){
			return false;
		} else {
			InputValidation passwordValidation = InputValidationFactory.getValidation("password");
			return passwordValidation.isValid(password);
		}
	}
		
		
		
	
	

}
