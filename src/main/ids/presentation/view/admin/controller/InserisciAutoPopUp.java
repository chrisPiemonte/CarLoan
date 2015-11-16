package main.ids.presentation.view.admin.controller;


import java.net.URL;
import java.time.LocalDate;
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
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.RequestType;
import main.ids.presentation.response.BasicResponse;
import main.ids.transferObjects.AutoTO;

public class InserisciAutoPopUp implements Initializable {
	
	public Button annulla;
	public Button conferma;
	public TextField targa;
	public TextField modello;
	public TextField stato;
	public TextField fascia;
	public TextField chilometraggio;
	public TextField agenzia;
	public DatePicker dataManutenzione;
	
	
	
	@Override 
	public void initialize(URL location, ResourceBundle resources){
		
		targa.setPromptText("inserisci targa...");
		targa.setFocusTraversable(false);
		modello.setPromptText("inserisci modello...");
		modello.setFocusTraversable(false);
		stato.setPromptText("inserisci stato...");
		stato.setFocusTraversable(false);
		fascia.setPromptText("inserisci fascia...");
		fascia.setFocusTraversable(false);
		chilometraggio.setPromptText("inserisci chilometraggio...");
		chilometraggio.setFocusTraversable(false);
		agenzia.setPromptText("inserisci agenzia...");
		agenzia.setFocusTraversable(false);
		annulla.setOnAction(e -> buttonClose());
		conferma.setOnAction(e -> {
			
		buttonConfirm();
		buttonClose();
		});

		
	}
	
	
	public void buttonClose(){
		Stage stage = (Stage) annulla.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
	
	public boolean buttonConfirm(){
		
		boolean inserito = addAuto(targa.getText(),modello.getText(),stato.getText(),fascia.getText(),chilometraggio.getText(),dataManutenzione.getValue(),agenzia.getText());
		return inserito;
	}
	
	public boolean addAuto(String targa, String modello, String stato, String fascia, String chilometraggio,LocalDate dataManutenzione,String agenzia){
		ArrayList<AutoTO> listaAuto = new ArrayList<AutoTO>();
		FrontController frontController = new DefaultFrontController();
		ComplexRequest request = new ComplexRequest();
		request.setType(RequestType.SERVICE);
		request.setRequest("addAuto");
		double km = Double.parseDouble(chilometraggio);
		AutoTO auto = new AutoTO(targa,modello,stato,fascia,km,dataManutenzione,agenzia);
		listaAuto.add(auto);
		request.setParameters(listaAuto);
		BasicResponse response = (BasicResponse) frontController.processRequest(request);
		if (response.isResponse()){
			Message.display("Auto inserita", AlertType.INFORMATION);
			return true;
		}
		else{
			Message.display("Auto non inserita", AlertType.INFORMATION);
			return false;
		}
		
		
	}

}














