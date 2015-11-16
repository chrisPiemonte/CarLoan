package main.ids.presentation.view.manager.controller.gestioneCliente;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.ids.presentation.DefaultFrontController;
import main.ids.presentation.FrontController;
import main.ids.presentation.request.BasicRequest;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.RequestType;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.view.controller.Message;
import main.ids.presentation.view.inputValidation.TaskValidationFactory;
import main.ids.transferObjects.ClienteTO;

public class InserisciClientePopUp implements Initializable {
	
	public Button annulla;
	public Button conferma;
	public TextField cf;
	public TextField nome;
	public TextField cognome;
	public TextField telefono;
	ArrayList<ClienteTO> nuovoCliente ;
	public DatePicker dataNascita;
	
	FrontController frontController ;
	
	
	
	
	@Override 
	public void initialize(URL location, ResourceBundle resources){
		
		//textField
		cf.setPromptText("inserisci codice fiscale...");
		cf.setFocusTraversable(false);
		nome.setPromptText("inserisci nome...");
		nome.setFocusTraversable(false);
		cognome.setPromptText("inserisci cognome...");
		cognome.setFocusTraversable(false);
		dataNascita.setFocusTraversable(false);
		telefono.setPromptText("inserisci numero di telefono...");
		telefono.setFocusTraversable(false);
		

		//bottoni
		annulla.setOnAction(e -> buttonClose());
		
		conferma.setOnAction(e -> {
			boolean check = buttonConfirm();
			if (check){
				Message.display("Elemento Inserito", AlertType.INFORMATION);
				chiudiPopUp();
			}
		});
		
	}
	
	
	public void buttonClose(){
		Stage stage = (Stage) annulla.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
	
	public boolean buttonConfirm(){
		if (TaskValidationFactory.controllaInserimentoCliente(cf.getText(), nome.getText(), cognome.getText(), telefono.getText(), dataNascita.getValue())){
			boolean check = addCliente(cf.getText().toString(), nome.getText().toString(),cognome.getText().toString(),dataNascita.getValue(),telefono.getText().toString());
			return check;
		}
		else{
			return false;
		}
		
		
	}
	
	
	public boolean addCliente(String cf,String nome,String cognome,LocalDate dataNascita, String telefono){
		
		ArrayList<ClienteTO> listlist = new ArrayList<ClienteTO>();
		ClienteTO newCli = new ClienteTO(cf,nome,cognome,dataNascita,telefono);
		listlist.add(newCli);
		frontController = new DefaultFrontController();
		ComplexRequest request = new ComplexRequest();
		request.setType(RequestType.SERVICE);
		request.setRequest("addCliente");
		request.setParameters(listlist);
		BasicResponse response = (BasicResponse) frontController.processRequest(request);
		return response.isResponse();
		
	}
	
	
	public void chiudiPopUp() {
		
		frontController = new DefaultFrontController();
		BasicRequest request = new BasicRequest();
		request.setType(RequestType.VIEW);
		request.setRequest("gestioneClienteManager");
		frontController.processRequest(request);
		buttonClose();
		
	}

}


















