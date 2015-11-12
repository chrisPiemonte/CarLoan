package main.ids.presentation.view.manager.controller;

import java.awt.List;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.ids.presentation.FrontController;
import main.ids.presentation.request.BasicRequest;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.RequestType;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.view.controller.Message;
import main.ids.transferObjects.ClienteTO;
import main.ids.transferObjects.ImpiegatoTO;

public class InserisciStaffPopUp implements Initializable {

	public TextField cf;
	public TextField nome;
	public TextField cognome;
	public TextField telefono;
	public TextField agenzia;
	public TextField username;
	public DatePicker dataNascita;
	
	public Button conferma;
	public Button annulla;
	
	ArrayList<ClienteTO> nuovoStaff ;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		
		
		
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
			 
			boolean check = addCliente(cf.getText(), nome.getText(),cognome.getText(),dataNascita.getValue(),telefono.getText(),agenzia.getText(),username.getText());
			return check;
			
		
		
	}
	
	public boolean addCliente (String cf,String nome,String cognome,LocalDate dataNascita, String telefono,String agenzia,String username){
		ArrayList<String> list = new ArrayList<>();
		ComplexRequest request = new ComplexRequest();
		FrontController frontController = new FrontController();
		request.setType(RequestType.SERVICE);
		request.setRequest("existsImpiegato");
		list.add(cf);
		request.setParameters(list);
		BasicResponse response = (BasicResponse)frontController.processRequest(request);
		boolean exists = response.isResponse();
		if(exists) {
			ArrayList<Object> impiegato = new ArrayList<Object>();
			impiegato.add(cf);
			impiegato.add(nome);
			impiegato.add(cognome);
			impiegato.add(dataNascita.toString());
			impiegato.add(telefono);
			impiegato.add(agenzia);
			impiegato.add(username);
			response = new BasicResponse();
			request = new ComplexRequest();
			frontController = new FrontController();
			request.setType(RequestType.SERVICE);
			request.setRequest("updateImpiegato");
			request.setParameters(impiegato);
			response = (BasicResponse) frontController.processRequest(request);
			if (response.isResponse())Message.display("elemento inserito", AlertType.INFORMATION);
			else Message.display("elemento non inserito", AlertType.INFORMATION);
			return true;
		}
		return false;
	}
	
	
	
	

}
