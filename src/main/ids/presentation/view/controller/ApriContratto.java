package main.ids.presentation.view.controller;

import java.awt.TextArea;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import main.ids.presentation.CurrentSessionHandler;
import main.ids.presentation.FrontController;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.RequestType;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.view.inputValidation.InputValidation;
import main.ids.presentation.view.inputValidation.InputValidationFactory;
import main.ids.presentation.view.model.AgenziaModel;
import main.ids.presentation.view.model.AutoModel;
import main.ids.transferObjects.AgenziaTO;
import main.ids.transferObjects.AutoTO;
import main.ids.transferObjects.ClienteTO;
import main.ids.transferObjects.ContrattoTO;
import main.ids.transferObjects.FasciaTO;

public class ApriContratto implements Initializable {
	
	public TextField cf; 
	public TextField nome;
	public TextField cognome;
	public DatePicker dataNascita;
	public TextField telefono;
	public SplitMenuButton apriSplitMenu;
	public MenuButton menu;
	public ComboBox comboAuto;
	public ComboBox comboAgenzia;
	public ComboBox comboMod;
	public DatePicker dataInizio;
	public DatePicker dataFine;
	public Button annulla;
	public Button ok; 
	
	FilteredList <AutoModel> autoList ;
	ObservableList<AgenziaModel> agenzieList = FXCollections.observableArrayList() ;
	ObservableList<AutoModel> tmp ;
	ObservableList<String> listMod = FXCollections.observableArrayList("illimitato","limitato");
	
	FrontController frontController;
	ComplexRequest request ;
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		/*cf.textProperty().addListener((v, oldValue, newValue) -> {
			checkCf(newValue);});*/
		
		buildComboAuto();
		
		//comboAuto.getItems().add("");
		for (AutoModel a : autoList){
		comboAuto.getItems().addAll(a.getModello());
		}
		comboMod.setItems(listMod);
		buildComboAgenzia();
		for (AgenziaModel a : agenzieList){
		comboAgenzia.getItems().add(a.getCittà());
		}
		
		
		
		/*comboAuto.getSelectionModel().selectedIndexProperty().addListener((v,oldValue,newValue)->{
			
			});
		*/

		//comboAuto.getSelectionModel().getSelectedIndex();
		
		
		cf.focusedProperty().addListener(new ChangeListener<Boolean>()
		{
		    @Override
		    public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
		    {
		        if (newPropertyValue)
		        {
		           
		        }
		        else
		        {
		        	
		        	checkCf(cf.getText());
		        	//comboAuto.getSelectionModel().getSelectedIndex();
		        	
		        }
		    }
		});
		
		ok.setOnAction(e -> {
			
		calcolaFattura();
		
		});
		
		
	}
	




	public boolean checkCf(String cf){
		FrontController frontController = new FrontController ();
		ArrayList<String> clienti = new ArrayList<String>();
		clienti.add(cf);
		ComplexRequest request = new ComplexRequest();
		request.setType(RequestType.SERVICE);
		request.setRequest("existsCliente");
		request.setParameters(clienti);
		BasicResponse bresponse = (BasicResponse) frontController.processRequest(request);
		if (bresponse.isResponse()){
				request = new ComplexRequest();
				request.setRequest("getCliente");
				request.setType(RequestType.SERVICE);
				request.setParameters(clienti);
				ComplexResponse<ClienteTO> response = (ComplexResponse<ClienteTO>) frontController.processRequest(request);
				ClienteTO cliente = (ClienteTO)response.getParameters().get(0);
				nome.setText(cliente.getNome());
				nome.setDisable(true);
				cognome.setText(cliente.getCognome());
				cognome.setDisable(true);
				dataNascita.setValue(cliente.getDataNascita());
				dataNascita.setDisable(true);
				telefono.setText(cliente.getTelefono());
				telefono.setDisable(true);	
				return true;
		}
		else {
			nome.setPromptText("Inserire nome...");
			nome.setDisable(false);
			cognome.setPromptText("Inserire cognome...");
			cognome.setDisable(false);
			dataNascita.setDisable(false);
			telefono.setPromptText("Inserire telefono...");
			telefono.setDisable(false);
			return false;
		}
		
	}
	
	public void buildComboAuto(){
		
		tmp = FXCollections.observableArrayList();
		frontController = new FrontController();
		ArrayList<String> checkAgenzia = new ArrayList<String>();
		checkAgenzia.add(CurrentSessionHandler.getAgenzia());
		request = new ComplexRequest();
		request.setRequest("getAutoByAgenzia");
		request.setParameters(checkAgenzia);
		request.setType(RequestType.SERVICE);
		ComplexResponse<AutoTO> response = (ComplexResponse<AutoTO>) frontController.processRequest(request);
		for (AutoTO cliente : response.getParameters()) {
			AutoModel tmpList = new AutoModel();
			tmpList.targa.set(cliente.getTarga());
			tmpList.modello.set(cliente.getModello());
			tmpList.stato.set(cliente.getStato());
			tmpList.fasciaAuto.set(cliente.getFascia());
			tmpList.km.set(cliente.getKm());
			tmpList.agenzia.set(cliente.getAgenzia());
			tmp.add(tmpList);
		}
		
		autoList = new FilteredList<>(tmp, p -> p.getStato().equals("D"));
		
		
	}
	
	
	public void buildComboAgenzia(){
		
		frontController = new FrontController();
		request = new ComplexRequest();
		request.setRequest("getAllAgenzie");
		request.setType(RequestType.SERVICE);
		ComplexResponse<AgenziaTO> response = (ComplexResponse<AgenziaTO>) frontController.processRequest(request);
		
		for (AgenziaTO a : response.getParameters()){
			AgenziaModel tmpList = new AgenziaModel();
			tmpList.id.set(a.getId());
			tmpList.città.set(a.getCitta());
			tmpList.indirizzo.set(a.getIndirizzo());
			tmpList.telefono.set(a.getTelefono());
			agenzieList.add(tmpList);
		}
		
		
		
	}
	
	public void calcolaFattura(){
		if (controllaInserimentoCliente() && checkDate() && checkInserimentoNoleggio()) {
					int autoIndex =  comboAuto.getSelectionModel().getSelectedIndex();
					String idFascia = autoList.get(autoIndex).getFasciaAuto();
					ArrayList<String> fasciaKey = new ArrayList<>();
					fasciaKey.add(idFascia);
					request = new ComplexRequest();
					request.setRequest("getFascia");
					request.setParameters(fasciaKey);
					request.setType(RequestType.SERVICE);
					ComplexResponse<FasciaTO> response = (ComplexResponse<FasciaTO>) frontController.processRequest(request);
					FasciaTO selectedFascia =  response.getParameters().get(0);
					System.out.println(selectedFascia.getTariffaGiornaliera());
					boolean modIllimitato;
					if (comboMod.getValue().equals("illimitato"))
						modIllimitato = true;
					else
						modIllimitato = false;
					double fattura = CalcoloTotale.setTotale(dataInizio.getValue(), dataFine.getValue(), selectedFascia, modIllimitato);
					boolean confermaInserimento = Message.display("la fattura è di "+fattura+" prezzo base \nContinuare?", AlertType.CONFIRMATION);
					if ( confermaInserimento){
						addContratto();
					}
					
		}else{
			
		}
		
	}
	
	
	public boolean checkDate(){
		if (dataInizio.getValue() != null && dataFine.getValue() != null ){
			if (dataInizio.getValue().isAfter(dataFine.getValue())){
				Message.display("Ops, c'è un errore nelle date", AlertType.ERROR);
				return false; 
			}else {
				return true;
			}
		}else {
			Message.display("Inserire data inizio e fine noleggio", AlertType.ERROR);
			return false;
		}
		
	}
	
	public boolean controllaInserimentoCliente(){
		if (campiVuoti()){
		InputValidation i = InputValidationFactory.getValidation("cf");
			if (i.isValid(cf.getText())){
				 i = InputValidationFactory.getValidation("nome");
				 if (i.isValid(nome.getText())){
					 i = InputValidationFactory.getValidation("cognome");
					 if (i.isValid(cognome.getText())){
						 i = InputValidationFactory.getValidation("telefono");
						 if (i.isValid(telefono.getText())){
							 return true;
						 }else {
							 Message.display("inserire numero di telefono", AlertType.ERROR);
							 return false;
						 }
					 }else { 
						 Message.display("cognome non inserito", AlertType.ERROR);
						 return false;
						
					 }
				 }else {
					 Message.display("nome non inserito", AlertType.ERROR);
					 return false;
				 }
				 	
				
			} else {
				Message.display("codice fiscale non inserito", AlertType.ERROR);
				return false;
			}
		}else {
			return false;
		}
		
	}
	
	public boolean campiVuoti(){
		if (cf.getText()!= null && nome.getText()!=null && cognome.getText()!= null && dataNascita.getValue() != null && telefono.getText() != null){
			return true;
		}else {
			Message.display("riempire tutti i campi del cliente", AlertType.ERROR);
			return false;
				
		}
	}
	
	
	public boolean checkInserimentoNoleggio(){
		if (comboAuto.getValue() != null && comboAgenzia != null && comboMod != null){
			return true;
		}else {
			Message.display("Inserire tutti i campi della sezione noleggio", AlertType.ERROR);
			return false;
		}
	}
	
	
	public void addContratto(){
		frontController = new FrontController();
		ArrayList<ContrattoTO> contratti = new ArrayList<>();
		ContrattoTO contratto = new ContrattoTO();
		request = new ComplexRequest();
		request.setType(RequestType.SERVICE);
		request.setRequest("apriContratto");
		
	}


}










