package main.ids.presentation.view.manager.controller;


import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.ids.presentation.CurrentSessionHandler;
import main.ids.presentation.FrontController;
import main.ids.presentation.request.BasicRequest;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.RequestType;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.view.controller.Message;
import main.ids.transferObjects.AccountTO;
import main.ids.transferObjects.ImpiegatoTO;

public class InserisciStaffPopUp implements Initializable {

	public TextField cf;
	public TextField nome;
	public TextField cognome;
	public TextField telefono;
	public TextField username;
	public DatePicker dataNascita;
	
	public Button conferma;
	public Button annulla;
	
	ArrayList<ImpiegatoTO> nuovoStaff ;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		cf.setPromptText("inserisci Codice fiscale");
		nome.setPromptText("inserisci Nome");
		cognome.setPromptText("inserisci Cognome");
		username.setPromptText("inserisci Username");
		telefono.setPromptText("Numero di telefono");
		cf.setFocusTraversable(false);
		nome.setFocusTraversable(false);
		cognome.setFocusTraversable(false);
		telefono.setFocusTraversable(false);
		username.setFocusTraversable(false);
		dataNascita.setFocusTraversable(false);

		
		
		
		
		conferma.setOnAction(e -> {
			boolean check = buttonConfirm();
			if (check){
				Message.display("Elemento Inserito", AlertType.INFORMATION);
				chiudiPopUp();
			}
		});
	
	
	}
	
	
	public void chiudiPopUp() {
			
			FrontController frontController = new FrontController();
			BasicRequest request = new BasicRequest();
			request.setType(RequestType.VIEW);
			request.setRequest("gestioneStaffManager");
			frontController.processRequest(request);
			buttonClose();
		
	}
	
	
	public void buttonClose(){
		Stage stage = (Stage) annulla.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
	
	
	public boolean buttonConfirm(){
			 
			boolean check = addStaff(cf.getText(), nome.getText(),cognome.getText(),dataNascita.getValue(),telefono.getText(),username.getText());
			return check;
			
		
		
	}
	
	public boolean addStaff(String cf,String nome,String cognome,LocalDate dataNascita, String telefono,String username){
		ArrayList<String> list = new ArrayList<>();
		ComplexRequest request = new ComplexRequest();
		FrontController frontController = new FrontController();
		request.setType(RequestType.SERVICE);
		request.setRequest("existsAccount");
		list.add(username);
		request.setParameters(list);
		BasicResponse response = (BasicResponse)frontController.processRequest(request);
		boolean exists = response.isResponse();
		if(!exists) {
				ArrayList<AccountTO> account = new ArrayList<AccountTO>();
				AccountTO newAccount = new AccountTO(username, "0000","impiegato");
				account.add(newAccount);
				request = new ComplexRequest();
				request.setType(RequestType.SERVICE);
				request.setRequest("addAccount");
				request.setParameters(account);
				BasicResponse response2 = (BasicResponse) frontController.processRequest(request);
				if(response2.isResponse()){
					ArrayList<ImpiegatoTO> impiegati = new ArrayList<ImpiegatoTO>();
					ImpiegatoTO impiegato = new ImpiegatoTO(cf,nome,cognome,dataNascita,telefono,CurrentSessionHandler.getAgenzia(),username);
					impiegati.add(impiegato);
					response = new BasicResponse();
					request = new ComplexRequest<>();
					frontController = new FrontController();
					request.setType(RequestType.SERVICE);
					request.setRequest("addImpiegato");
					request.setParameters(impiegati);
					response = (BasicResponse) frontController.processRequest(request);
				}	
				if (response.isResponse()&& response2.isResponse())Message.display("elemento inserito", AlertType.INFORMATION);
				else Message.display("elemento non inserito", AlertType.INFORMATION);
				return true;
		} else { Message.display("Username non disponibile", AlertType.ERROR);
				 
			
		}
		return false;
	}
	
	
	
	

}
