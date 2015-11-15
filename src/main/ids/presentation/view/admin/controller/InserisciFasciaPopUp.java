package main.ids.presentation.view.admin.controller;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.ids.presentation.FrontController;
import main.ids.presentation.request.BasicRequest;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.RequestType;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.view.inputValidation.TaskValidationFactory;
import main.ids.transferObjects.FasciaTO;

public class InserisciFasciaPopUp implements Initializable {
	
	public Button annulla;
	public Button conferma;
	public TextField id;
	public TextField descrizione;
	public TextField tariffaGiornaliera;
	public TextField tariffaSettimanale;
	public TextField tariffakm;
	
	
	
	@Override 
	public void initialize(URL location, ResourceBundle resources){
		
		//textField
		id.setPromptText("inserisci identificativo...");
		id.setFocusTraversable(false);
		descrizione.setPromptText("inserisci descrizione...");
		descrizione.setFocusTraversable(false);
		tariffaGiornaliera.setPromptText("tariffa giornaliera...");
		tariffaGiornaliera.setFocusTraversable(false);
		tariffaSettimanale.setPromptText("tariffa settimanale...");
		tariffaSettimanale.setFocusTraversable(false);
		tariffakm.setPromptText("tariffa per chilometri...");
		tariffakm.setFocusTraversable(false);
		
		//bottoni
		annulla.setOnAction(e -> buttonClose());
		conferma.setOnAction(e -> {
			if (TaskValidationFactory.getFasciaValidation(id.getText(), descrizione.getText(), tariffaGiornaliera.getText(), tariffaSettimanale.getText(), tariffakm.getText())){
				FasciaTO fasciaTO = new FasciaTO(id.getText(),descrizione.getText(), Double.parseDouble(tariffaGiornaliera.getText()), Double.parseDouble(tariffaSettimanale.getText()), Double.parseDouble(tariffakm.getText()));
				addFascia(fasciaTO);
				chiudiPopUp();
			}
			
		});
	}
	
	
	public void buttonClose(){
		Stage stage = (Stage) annulla.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
	
	public void chiudiPopUp() {
			
			FrontController frontController = new FrontController();
			BasicRequest request = new BasicRequest();
			request.setType(RequestType.VIEW);
			request.setRequest("gestioneFasciaAdmin");
			frontController.processRequest(request);
			buttonClose();
		
	}
	
	
	public void addFascia(FasciaTO fascia){
		FrontController frontController = new FrontController();
		ComplexRequest request = new ComplexRequest();
		ArrayList<FasciaTO> fasce = new ArrayList<FasciaTO>();
		fasce.add(fascia);
		request.setType(RequestType.SERVICE);
		request.setRequest("addFascia");
		request.setParameters(fasce);
		BasicResponse response = (BasicResponse) frontController.processRequest(request);
		if (response.isResponse()){
			Message.display("elemento inserito", AlertType.INFORMATION);
		}else {
			Message.display("elemento non inserito", AlertType.ERROR);
		}
	}

}






















