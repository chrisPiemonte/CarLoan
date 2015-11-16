package main.ids.presentation.view.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import main.ids.presentation.CurrentSessionHandler;
import main.ids.presentation.DefaultFrontController;
import main.ids.presentation.FrontController;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.RequestType;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.view.inputValidation.InputValidation;
import main.ids.presentation.view.inputValidation.InputValidationFactory;
import main.ids.transferObjects.AccountTO;

public class CambiaPassword implements Initializable {
	
	public PasswordField vecchiaPass;
	public PasswordField nuovaPass;
	public PasswordField nuovaPass2;
	public Button okButton;
	public Button annullaButton;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		okButton.setOnAction(e -> cambia());
		
	}
	
	public void cambia(){
		FrontController frontController = new DefaultFrontController();
		ComplexRequest request = new ComplexRequest();
		request.setType(RequestType.SERVICE);
		request.setRequest("getPasswordOf");
		List<String> account = new ArrayList<>();
		account.add(CurrentSessionHandler.getUsername());
		request.setParameters(account);
		ComplexResponse<String> response = (ComplexResponse<String>) frontController.processRequest(request);
		String password = response.getParameters().toString();
		password = password.substring(1, password.length()-1);
		System.out.println(password);
		//InputValidation i = InputValidationFactory.getValidation("password");
		//i.isValid(vecchiaPass.getText());
		if (password.equals(vecchiaPass.getText())){
			if (nuovaPass.getText().equals(nuovaPass2.getText())){
				frontController = new DefaultFrontController();
				List<AccountTO> finalAccounts = new ArrayList<AccountTO>();
				AccountTO finalAccount = new AccountTO(CurrentSessionHandler.getUsername(),nuovaPass.getText(),CurrentSessionHandler.getTipoAccesso());
				request = new ComplexRequest();
				request.setType(RequestType.SERVICE);
				finalAccounts.add(finalAccount);
				request.setRequest("updateAccount");
				request.setParameters(finalAccounts);
				BasicResponse response2 = (BasicResponse) frontController.processRequest(request);
				if(response2.isResponse()) Message.display("Modifica avvenuta con successo", AlertType.INFORMATION);
			}else {
				Message.display("Attenzione, la nuova password non è stata ripetuta male", AlertType.ERROR);
			}
		}else {
			Message.display("Vecchia password, non valida", AlertType.ERROR);
		}
		
		
		
	}
	
	
	

}
