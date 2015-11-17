package main.ids.presentation.view.controller;


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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.ids.presentation.CurrentSessionHandler;
import main.ids.presentation.DefaultFrontController;
import main.ids.presentation.FrontController;
import main.ids.presentation.request.BasicRequest;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.RequestType;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.view.admin.controller.Message;
import main.ids.presentation.view.inputValidation.InputValidation;
import main.ids.presentation.view.inputValidation.InputValidationFactory;
import main.ids.presentation.view.inputValidation.TaskValidationFactory;
import main.ids.presentation.view.model.AgenziaModel;
import main.ids.presentation.view.model.AutoModel;
import main.ids.transferObjects.AgenziaTO;
import main.ids.transferObjects.AutoTO;
import main.ids.transferObjects.ClienteTO;
import main.ids.transferObjects.ContrattoTO;
import main.ids.transferObjects.FasciaTO;

/**
 * Permette l'apertura di un nuovo contratto.
 * l'input inseriti riguardano il cliente, le modalità 
 * di noleggio, e le informazioni dell'impiegato 
 * che esegue l'operazione
 * @author bi
 *
 */
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
	public ComboBox comboDurata;
	public DatePicker dataInizio;
	public DatePicker dataFine;
	public Button annulla;
	public Button ok; 
	public TextField acconto;
	
	FilteredList <AutoModel> autoList ;
	ObservableList<AgenziaModel> agenzieList = FXCollections.observableArrayList() ;
	ObservableList<AutoModel> tmp ;
	ObservableList<String> listMod = FXCollections.observableArrayList("Illimitato","Limitato");
	ObservableList<String> listDurata = FXCollections.observableArrayList("giornaliero","settimanale");
	
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
		comboDurata.setItems(listDurata);
		
		
		
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
	

	/**Controlla se il codice fiscale inserito è già 
	 * presente nel sistema, in caso positivo 
	 * l'interfaccia riempirà automaticamente 
	 * i campi relativi all utente
	 * 
	 * @param cf codice fiscale
	 * @return boolean and check if exists
	 */


	public boolean checkCf(String cf){
		FrontController frontController = new DefaultFrontController ();
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
	
	/**Permette la costruzione del menu a tendina delle auto.
	 * Le auto sono prelevate in base all'agenzia ed allo 
	 * stato (disponibili o meno) 
	 * 
	 */

	public void buildComboAuto(){
		
		tmp = FXCollections.observableArrayList();
		frontController = new DefaultFrontController();
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
	
	/**Metodo per la costruzione del menu a tendina 
	 * delle agenzie, per selezionare dove effetuare
	 * la consegna dell'auto
	 * 
	 */
	
	public void buildComboAgenzia(){
		
		frontController = new DefaultFrontController();
		request = new ComplexRequest();
		request.setRequest("getAllAgenzie");
		request.setType(RequestType.SERVICE);
		ComplexResponse<AgenziaTO> response = (ComplexResponse<AgenziaTO>) frontController.processRequest(request);
		
		for (AgenziaTO a : response.getParameters()){
			AgenziaModel tmpList = new AgenziaModel();
			tmpList.id.set(a.getId());
			tmpList.città.set(a.getCitta());
			tmpList.indirizzo.set(a.getIndirizzo());
			tmpList.telefonoAgenzia.set(a.getTelefono());
			agenzieList.add(tmpList);
		}
		
		
		
	}
	/**Calcola la fattura preliminare del contratto
	 * in base ad i primi dati inseriti
	 * 
	 */
	public void calcolaFattura(){
		if(TaskValidationFactory.controllaInserimentoCliente(cf.getText(),nome.getText(),cognome.getText(),telefono.getText(),dataNascita.getValue()))
		if (checkDate() && checkInserimentoNoleggio()) {
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
					if (acconto.getText().isEmpty()){
						Message.display("Inserire acconto", AlertType.ERROR);
					}else{
						InputValidation i = InputValidationFactory.getValidation("double");
						if(i.isValid(acconto.getText())) Message.display("Acconto non valido", AlertType.ERROR);
						
					}
					
					double tariffaBase = CalcoloTotale.getTariffaBase(selectedFascia, comboMod.getValue().toString(), comboDurata.getValue().toString());
					double fattura = CalcoloTotale.setTotale(dataInizio.getValue(), dataFine.getValue(), tariffaBase,1,comboMod.getValue().toString());
					boolean confermaInserimento = Message.display("la fattura è di "+fattura+" prezzo base \nContinuare?", AlertType.CONFIRMATION);
					if (confermaInserimento){
						
						ContrattoTO contrattoInserito = new ContrattoTO();
						contrattoInserito.setCliente(cf.getText());
						contrattoInserito.setAuto(autoList.get(autoIndex).getTarga());
						contrattoInserito.setKmNoleggio(comboMod.getValue().toString());
						contrattoInserito.setPrezzoKm(selectedFascia.getTariffaKm());
						contrattoInserito.setModNoleggio(comboDurata.getValue().toString());
						contrattoInserito.setDataInizio(dataInizio.getValue());
						contrattoInserito.setDataFine(dataFine.getValue());
						contrattoInserito.setAgenziaInizio(CurrentSessionHandler.getAgenzia());
						contrattoInserito.setAgenziaFine(agenzieList.get(comboAgenzia.getSelectionModel().getSelectedIndex()).getId());
						contrattoInserito.setImpInizio(CurrentSessionHandler.getCf());
						contrattoInserito.setAcconto(Double.parseDouble(acconto.getText()));
						contrattoInserito.setStatoContratto("aperto");
						contrattoInserito.setTariffaBase(tariffaBase);
						contrattoInserito.setTotale(0);
						contrattoInserito.setImpFine(null);
						contrattoInserito.setKmPercorsi(0);
						modificaStatoAuto(autoList.get(autoIndex).getTarga());
						if (addContratto(contrattoInserito));
						
						Message.display("Contratto inserito", AlertType.INFORMATION);
						
						// QUI AVVIENE LA CHIUSURA
						chiudiPopUp();
						
						
						
						} 
					
		}else{
			
		}
		
	}
	
	/**Controlla che le date siano valide
	 * 
	 * @return boolean per la validazione
	 */
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
	
	/**Controllo dei dati,riguardante il noleggio, inseriti
	 * 
	 * @return
	 */
	
	public boolean checkInserimentoNoleggio(){
		if (comboAuto.getValue() != null && comboAgenzia != null && comboMod != null && comboDurata != null){
			return true;
		}else {
			Message.display("Inserire tutti i campi della sezione noleggio", AlertType.ERROR);
			return false;
		}
	}
	
	/**Aggiunge il contratto nel sistema.
	 * 
	 * @param contrattoTO {@link ContrattoTO}
	 * @return
	 */
	public boolean addContratto(ContrattoTO contrattoTO){
		frontController = new DefaultFrontController();
		ArrayList<ContrattoTO> contratti = new ArrayList<>();
		contratti.add(contrattoTO);
		request = new ComplexRequest();
		request.setType(RequestType.SERVICE);
		request.setRequest("apriContratto");
		request.setParameters(contratti);
		BasicResponse response = (BasicResponse) frontController.processRequest(request);
		return response.isResponse();
		
	}
	
	
	
	public void chiudiPopUp() {
		
		FrontController frontController = new DefaultFrontController();
		BasicRequest request = new BasicRequest();
		request.setType(RequestType.VIEW);
		request.setRequest("gestioneContratti");
		frontController.processRequest(request);
		buttonClose();
	
}


	public void buttonClose(){
		Stage stage = (Stage) annulla.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
	
	/**Modifica lo stato dell'auto utilizzata per il noleggio
	 * 
	 * @param targa
	 */
	public void modificaStatoAuto(String targa){
		ArrayList<String> auto = new ArrayList<>();
		frontController = new DefaultFrontController ();
		ComplexRequest request = new ComplexRequest();
		request.setType(RequestType.SERVICE);
		request.setRequest("changeStatoOfAuto");
		auto.add(targa);
		auto.add("N");
		request.setParameters(auto);
		frontController.processRequest(request);
		
	}


}










