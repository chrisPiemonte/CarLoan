package main.ids.presentation.view.manager.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import main.ids.presentation.CurrentSessionHandler;
import main.ids.presentation.DefaultFrontController;
import main.ids.presentation.FrontController;
import main.ids.presentation.request.BasicRequest;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.RequestType;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.view.admin.controller.Message;
import main.ids.presentation.view.controller.CalcoloTotale;
import main.ids.transferObjects.ContrattoTO;
import main.ids.util.json.ViewsJsonParser;

public class ChiudiContratto implements Initializable {
	
	FrontController frontController;
	ComplexRequest request; 
	
	@FXML
	public DatePicker dataRientro;
	@FXML
	public TextField textKm;
	@FXML
	public Button ok;
	@FXML
	public Button annulla;
	
	
	
	
	public ChiudiContratto(){
		
	}
	
		
		
	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
		
		 textKm.setPromptText("inserisci km percorsi");
		 ok.setOnAction(e -> {
			 stampaFattura();
			 chiudiPopUp();
			 
		 });
		 annulla.setOnAction(e -> chiudiPopUp());
		 // chiamo il contratto
		 
	 }
	 
	 
	 
	 
	public void stampaFattura(){
		FrontController frontController = new DefaultFrontController();
		 ComplexRequest request = new ComplexRequest();
		 request.setType(RequestType.SERVICE);
		 request.setRequest("getContratto");
		 List<String> contratti = new ArrayList<String>();
		 contratti.add(CurrentSessionHandler.getIdContratto());
		 request.setParameters(contratti);
		 ComplexResponse<ContrattoTO> response = (ComplexResponse<ContrattoTO>) frontController.processRequest(request);
		 ContrattoTO contratto = response.getParameters().get(0);
		 double tot = CalcoloTotale.setTotale(contratto.getDataInizio(), contratto.getDataFine(), contratto.getTariffaBase(), Double.parseDouble(textKm.getText()), contratto.getKmNoleggio());
		 int days = Period.between(contratto.getDataFine(), dataRientro.getValue()).getDays();
		 boolean confirmation = Message.display("Totale fattura: "+tot+"\n giorni di ritardo:"+days+"\n acconto:"+contratto.getAcconto()+"\n vuoi chiudere contratto?", AlertType.CONFIRMATION);
		 if (confirmation){
			 contratto.setTotale(tot);
			 contratto.setImpFine(CurrentSessionHandler.getCf());
			 contratto.setKmPercorsi(Double.parseDouble(textKm.getText()));
			 chiudi(tot);
		 }
	}
	
	
	public void chiudi(Double tot){
		FrontController frontController = new DefaultFrontController();
		ComplexRequest request = new ComplexRequest();
		request.setRequest("chiudiContratto");
		List<Object> chiusura = new ArrayList<Object>();
		chiusura.add(CurrentSessionHandler.getIdContratto());
		chiusura.add(CurrentSessionHandler.getUsername());
		chiusura.add(Double.parseDouble(textKm.getText()));
		chiusura.add(tot);
		request.setParameters(chiusura);
		request.setType(RequestType.SERVICE);
		BasicResponse response = (BasicResponse) frontController.processRequest(request);
		if (response.isResponse()) Message.display("Contratto chiuso", AlertType.INFORMATION);
	}
	
	
	
	
	
	
	
	public void buttonClose(){
		Stage stage = (Stage) annulla.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
	
	public void chiudiPopUp() {
		
		FrontController frontController = new DefaultFrontController();
		BasicRequest request = new BasicRequest();
		request.setType(RequestType.VIEW);
		request.setRequest("gestioneContrattiManager");
		frontController.processRequest(request);
		buttonClose();
	
	}
	
	
	
	

}




