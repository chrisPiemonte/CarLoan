package main.ids.presentation.view.controller.gestioneCliente;

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
import main.ids.presentation.view.inputValidation.InputValidation;
import main.ids.presentation.view.inputValidation.InputValidationFactory;
import main.ids.presentation.view.inputValidation.TaskValidationFactory;
import main.ids.transferObjects.ClienteTO;
/**
 * Finestra per l'inserimento dei nuovi utenti.
 * Prende in input i dati inseriti tramite l'interfaccia e 
 * dopo averli convalidati tramite la {@link TaskValidationFactory}
 * vengono inseriti come parametri di {@link Request} gestiti dal 
 * {@link DefaultFrontController} che risponde con una {@link Request} per 
 * confermare l'operazione
 * @author bi
 *
 */
public class InserisciClientePopUp implements Initializable {
	
	public Button annulla;
	public Button conferma;
	public TextField cf;
	public TextField nome;
	public TextField cognome;
	public TextField telefono;
	public DatePicker dataNascita;
	ArrayList<ClienteTO> nuovoCliente ;
	
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
	
	/**
	 * metodo per la chiusura della finestra
	 */
	public void buttonClose(){
		Stage stage = (Stage) annulla.getScene().getWindow();
	    stage.close();
	}
	
	public boolean buttonConfirm(){
		
		
		boolean inputCheck = TaskValidationFactory.getClienteValidation(cf.getText(), nome.getText(), cognome.getText(), dataNascita.getValue(), telefono.getText());
		if(inputCheck){
		boolean check = addCliente(cf.getText().toString(), nome.getText().toString(),cognome.getText().toString(),dataNascita.getValue(),telefono.getText().toString());
		return check;
		}else {
			clean();
			return false;
		}
		
		
	}
	/**
	 * Metodo per l'inserimento del cliente.
	 * Prende in input i dati inseriti dall'interfaccia
	 * @param cf
	 * @param nome
	 * @param cognome
	 * @param dataNascita
	 * @param telefono
	 * @return boolean 
	 */
	
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
		request.setRequest("gestioneCliente");
		frontController.processRequest(request);
		buttonClose();
		
	}
	/**
	 * medoto di servizio per la pulizia dei campi
	 */
	public void clean(){
		cf.clear();
		nome.clear();
		cognome.clear();
		telefono.clear();
	}
	
	

}


















