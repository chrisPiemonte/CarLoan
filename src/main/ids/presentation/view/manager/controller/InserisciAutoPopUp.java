package main.ids.presentation.view.manager.controller;


import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.ids.presentation.CurrentSessionHandler;
import main.ids.presentation.FrontController;
import main.ids.presentation.request.BasicRequest;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.RequestType;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.view.model.FasciaModel;
import main.ids.transferObjects.AutoTO;
import main.ids.transferObjects.FasciaTO;

public class InserisciAutoPopUp implements Initializable {
	
	public Button annulla;
	public Button conferma;
	public TextField targa;
	public TextField modello;
	public ComboBox<String> stato;
	public ComboBox fascia;
	public TextField chilometraggio;
	public DatePicker dataManutenzione;
	
	private ObservableList<FasciaModel> fasciaList;
	
	
	
	@Override 
	public void initialize(URL location, ResourceBundle resources){
		stato.getItems().addAll("Disponibile","Manutenzione","Non-disponibile");
		buildFasce();
		for (FasciaModel f : fasciaList){
			fascia.getItems().add(f.getId());
		}
		
		targa.setPromptText("inserisci targa...");
		targa.setFocusTraversable(false);
		modello.setPromptText("inserisci modello...");
		modello.setFocusTraversable(false);
		chilometraggio.setPromptText("inserisci chilometraggio...");
		chilometraggio.setFocusTraversable(false);
		annulla.setOnAction(e -> buttonClose());
		conferma.setOnAction(e -> {
			
		buttonConfirm();
		chiudiPopUp();
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
			request.setRequest("gestioneAutoManager");
			frontController.processRequest(request);
			buttonClose();
			
		}
	
	public boolean buttonConfirm(){
		
		boolean inserito = addAuto(targa.getText(),modello.getText(),stato.getValue().toString().substring(0,1),fascia.getValue().toString(),chilometraggio.getText(),dataManutenzione.getValue());
		return inserito;
	}
	
	public boolean addAuto(String targa, String modello, String stato, String fascia, String chilometraggio,LocalDate dataManutenzione){
		ArrayList<AutoTO> listaAuto = new ArrayList<AutoTO>();
		FrontController frontController = new FrontController();
		ComplexRequest request = new ComplexRequest();
		request.setType(RequestType.SERVICE);
		request.setRequest("addAuto");
		double km = Double.parseDouble(chilometraggio);
		AutoTO auto = new AutoTO(targa,modello,stato,fascia,km,dataManutenzione,CurrentSessionHandler.getAgenzia());
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
	
	
	public void buildFasce(){
		fasciaList = FXCollections.observableArrayList();
		FrontController frontController = new FrontController();
		ComplexRequest request = new ComplexRequest();
		request.setType(RequestType.SERVICE);
		request.setRequest("getAllFasce");
		ComplexResponse<FasciaTO> response = (ComplexResponse<FasciaTO>) frontController.processRequest(request);
		System.out.println(response.isResponse());
			for (FasciaTO f : response.getParameters()){
				FasciaModel tmpList = new FasciaModel();
				tmpList.id.set(f.getId());
				tmpList.descrizione.set(f.getDescrizione());
				tmpList.tariffaGiornaliera.set(f.getTariffaGiornaliera());
				tmpList.tariffaSettimanale.set(f.getTariffaSettimanale());
				tmpList.tariffaKm.set(f.getTariffaKm());
				fasciaList.add(tmpList);
				System.out.println(tmpList.getId());
			
		}
		
	}

}














