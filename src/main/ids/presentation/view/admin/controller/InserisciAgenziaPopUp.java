package main.ids.presentation.view.admin.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.ids.presentation.DefaultFrontController;
import main.ids.presentation.FrontController;
import main.ids.presentation.request.BasicRequest;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.RequestType;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.view.inputValidation.InputValidation;
import main.ids.presentation.view.inputValidation.InputValidationFactory;
import main.ids.transferObjects.AgenziaTO;
/**Permette l inserimento di una nuova agenzia
 * 
 * @author bi
 *
 */
public class InserisciAgenziaPopUp implements Initializable{
	
	public TextField textFieldCittà;
	public TextField textFieldIndirizzo;
	public TextField textFieldTelefono;
	public Button annulla;
	public Button conferma;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		textFieldCittà.setPromptText("inserisci città");
		textFieldIndirizzo.setPromptText("inserisci indirizzo");
		textFieldTelefono.setPromptText("inserisci telefono");
		textFieldCittà.setFocusTraversable(false);
		textFieldIndirizzo.setFocusTraversable(false);
		textFieldTelefono.setFocusTraversable(false);
		
		
		conferma.setOnAction(e -> {
			
		if (checkInput()) {
			inserisciAgenzia();
		}
		});
		annulla.setOnAction(e -> chiudiPopUp());
		
		
	}
	/**verifica i paramentri d'input
	 * 
	 * @return un boolean di verifica 
	 */
	
	public boolean checkInput(){
		
		InputValidation i = InputValidationFactory.getValidation("nome");
		if ( i.isValid(textFieldCittà.getText())){
			i = InputValidationFactory.getValidation("telefono");
			if (i.isValid(textFieldTelefono.getText())){
				return true;
			}else {
				Message.display("Telefono non valido", AlertType.ERROR);
				return false;
			}
			
		}else {
			Message.display("Città non valida", AlertType.ERROR);
			return false;
		}
		
	}
	
	
	public void chiudiPopUp() {
		
		FrontController frontController = new DefaultFrontController();
		BasicRequest request = new BasicRequest();
		request.setType(RequestType.VIEW);
		request.setRequest("gestioneStaffAdmin");
		frontController.processRequest(request);
		buttonClose();
	
	}
	
	public void buttonClose(){
		Stage stage = (Stage) annulla.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
	
	/**Effettua l'inserimento dell'azienda
	 * 
	 */
	public void inserisciAgenzia(){
		ArrayList<AgenziaTO> agenzie = new ArrayList<>();
		AgenziaTO agenzia = new AgenziaTO(textFieldCittà.getText(),textFieldIndirizzo.getText(),textFieldTelefono.getText());
		agenzie.add(agenzia);
		FrontController frontController = new DefaultFrontController();
		ComplexRequest request = new ComplexRequest();
		request.setType(RequestType.SERVICE);
		request.setRequest("addAgenzia");
		request.setParameters(agenzie);
		BasicResponse response = (BasicResponse) frontController.processRequest(request);
		if (response.isResponse()){
			Message.display("Elemento inserito", AlertType.INFORMATION);
			chiudiPopUp();
		}
		
		
	}

	
	

}





















