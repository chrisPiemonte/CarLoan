package main.ids.presentation.view.admin.controller;

import java.awt.List;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.ids.presentation.DefaultFrontController;
import main.ids.presentation.FrontController;
import main.ids.presentation.request.BasicRequest;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.RequestType;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.view.controller.Message;
import main.ids.presentation.view.inputValidation.TaskValidationFactory;
import main.ids.presentation.view.model.AgenziaModel;
import main.ids.transferObjects.AccountTO;
import main.ids.transferObjects.AgenziaTO;
import main.ids.transferObjects.ClienteTO;
import main.ids.transferObjects.ImpiegatoTO;
import main.ids.transferObjects.ManagerTO;

/**Permette l'inserimento di staff, quali manager o impiegati
 * all'interno del sistema in una azienda scelta fra le disponibili
 * 
 * @author bi
 *
 */
public class InserisciStaffPopUp implements Initializable {

	public TextField cf;
	public TextField nome;
	public TextField cognome;
	public TextField telefono;
	public TextField agenzia;
	public TextField username;
	public DatePicker dataNascita;
	public ComboBox<String> comboRuolo;
	public ComboBox<String> comboAgenzia;
	
	public Button conferma;
	public Button annulla;
	
	ArrayList<ImpiegatoTO> nuovoStaff ;
	private ObservableList<AgenziaModel> listaAgenzia;
	
	FrontController frontController;
	ComplexRequest request;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		cf.setPromptText("inserisci codice fiscale");
		nome.setPromptText("inserisci nome");
		cognome.setPromptText("inserisci cognome");
		telefono.setPromptText("inserisci telefono");
		username.setPromptText("inserisci username");
		cf.setFocusTraversable(false);
		nome.setFocusTraversable(false);
		cognome.setFocusTraversable(false);
		telefono.setFocusTraversable(false);
		username.setFocusTraversable(false);
		
		comboRuolo.getItems().addAll("Manager","Impiegato");
		buildData();
		for (AgenziaModel a : listaAgenzia){
			comboAgenzia.getItems().add(a.getCittà()+" "+a.getIndirizzo());
		}
		conferma.setOnAction(e -> {
			boolean check = buttonConfirm();
			if (check){
				Message.display("Elemento Inserito", AlertType.INFORMATION);
				chiudiPopUp();
			}
		});
		
		annulla.setOnAction(e -> chiudiPopUp());
	
	
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
	
	/**Controlla l'inserimento de i dati, ed in particolare
	 * nel caso del manager, controlla se è già presente
	 * in quanto vi è al più un manager per agenzia
	 * 
	 * @return
	 */
	public boolean buttonConfirm(){
		//{
			if (comboRuolo.getValue() != null){
				if (comboRuolo.getValue().equals("Manager")){
					frontController = new DefaultFrontController();
					ComplexRequest request = new ComplexRequest();
					request.setType(RequestType.SERVICE);
					request.setRequest("getManagerOfAgenzia");
					ArrayList<String> idAgenzia = new ArrayList<String> ();
					idAgenzia.add(String.valueOf(comboAgenzia.getSelectionModel().getSelectedIndex()+1));
					request.setParameters(idAgenzia);
					ComplexResponse<ManagerTO> response = (ComplexResponse<ManagerTO>)frontController.processRequest(request);
					if (response.getParameters().get(0).getCf() == null){
						if (!existsAccount(username.getText()) ){
							boolean check = addManager(cf.getText(), nome.getText(),cognome.getText(),dataNascita.getValue(),telefono.getText(),String.valueOf(comboAgenzia.getSelectionModel().getSelectedIndex()+1),username.getText());
							return check;
					}   else{
							Message.display("Username non disponibile", AlertType.ERROR);
							return false;
					}

					
				}else {
					Message.display("Manager già presente per questa azienda", AlertType.ERROR);
					return false;
					}
				}else {
					// INSERIRE IMPIEGATO
					if (!existsAccount(username.getText())){
						return addImpiegato(cf.getText(), nome.getText(),cognome.getText(),dataNascita.getValue(),telefono.getText(),String.valueOf(comboAgenzia.getSelectionModel().getSelectedIndex()+1),username.getText());
					}else {
						Message.display("Username non disponibile", AlertType.ERROR);
						return false;
					}
					
				}
			}else {
				Message.display("Scegliere un ruolo", AlertType.INFORMATION);
				return false;
			}
		//}
	}
	/**Permette l'inserimento di un manager ed imposta una password iniziale
	 * 
	 * @param cf codice fiscale di un manager
	 * @param nome nome di battesimo 
	 * @param cognome cognome 
	 * @param dataNascita data di nascita
	 * @param telefono numero di telefono 
	 * @param agenzia identificativo scelto tra le agenzie disponibili
	 * @param username per le credenziali d'accesso
	 * @return controlla l'avvenuto inserimento 
	 */
	public boolean addManager(String cf,String nome,String cognome,LocalDate dataNascita, String telefono,String agenzia,String username){
			if(TaskValidationFactory.controllaInserimentoCliente(cf, nome, cognome, telefono, dataNascita)) {
				ArrayList<AccountTO> account = new ArrayList<AccountTO>();
				AccountTO newAccount = new AccountTO(username, "manager","manager");
				account.add(newAccount);
				request = new ComplexRequest();
				request.setType(RequestType.SERVICE);
				request.setRequest("addAccount");
				request.setParameters(account);
				BasicResponse response2 = (BasicResponse) frontController.processRequest(request);
				if(response2.isResponse()){
					ArrayList<ManagerTO> impiegati = new ArrayList<ManagerTO>();
					ManagerTO impiegato = new ManagerTO(cf,nome,cognome,dataNascita,telefono,agenzia,username);
					impiegati.add(impiegato);
					BasicResponse response = new BasicResponse();
					request = new ComplexRequest();
					frontController = new DefaultFrontController();
					request.setType(RequestType.SERVICE);
					request.setRequest("addManager");
					request.setParameters(impiegati);
					response = (BasicResponse) frontController.processRequest(request);
					
					if (response.isResponse()&& response2.isResponse())
					{
						Message.display("elemento inserito", AlertType.INFORMATION);
						return true;
					
					}
					else {
						Message.display("elemento non inserito", AlertType.INFORMATION);
						return true;
					}
					
		} else { 
			Message.display("Username non disponibile", AlertType.ERROR);
				 
			
		}
		return false;
		
		}
			else return false;
	}
	/**Permette l'inserimento di un impiegato ed imposta una password iniziale 
	 * 
	 * @param cf codice fiscale
	 * @param nome nome di battesimo 	
	 * @param cognome cognome
	 * @param dataNascita data di nascita
	 * @param telefono numero di telefono 
	 * @param agenzia id dell'agenzia 
	 * @param username username per le credenziali d'accesso
	 * @return verifica se è avvenuto l'inserimento 
	 */
		public boolean addImpiegato(String cf,String nome,String cognome,LocalDate dataNascita, String telefono,String agenzia,String username){
				ArrayList<AccountTO> account = new ArrayList<AccountTO>();
				AccountTO newAccount = new AccountTO(username, "0000","impiegato");
				account.add(newAccount);
				request = new ComplexRequest();
				request.setType(RequestType.SERVICE);
				request.setRequest("addAccount");
				request.setParameters(account);
				BasicResponse response2 = (BasicResponse) frontController.processRequest(request);
				if(response2.isResponse()){
					ArrayList<ImpiegatoTO> impiegati = new ArrayList<ImpiegatoTO>();
					ImpiegatoTO impiegato = new ImpiegatoTO(cf,nome,cognome,dataNascita,telefono,agenzia,username);
					impiegati.add(impiegato);
					BasicResponse response = new BasicResponse();
					request = new ComplexRequest();
					frontController = new DefaultFrontController();
					request.setType(RequestType.SERVICE);
					request.setRequest("addImpiegato");
					request.setParameters(impiegati);
					response = (BasicResponse) frontController.processRequest(request);
					
					if (response.isResponse()&& response2.isResponse())
					{
						Message.display("elemento inserito", AlertType.INFORMATION);
						return true;
					
					}
					else {
						Message.display("elemento non inserito", AlertType.INFORMATION);
						return true;
					}
					
		} else { 
			Message.display("Username non disponibile", AlertType.ERROR);
				 
			
		}
		return false;
		}
	
	
	public void buildData(){
		frontController = new DefaultFrontController();
		listaAgenzia = FXCollections.observableArrayList();
		ComplexRequest request = new ComplexRequest();
		request.setType(RequestType.SERVICE);
		request.setRequest("getAllAgenzie");
		ComplexResponse<AgenziaTO> response = (ComplexResponse<AgenziaTO>) frontController.processRequest(request);
		if (response.getParameters()!= null){
			for(AgenziaTO agenzia : response.getParameters()){
				AgenziaModel tmpList = new AgenziaModel();
				tmpList.id.set(agenzia.getId());
				tmpList.città.set(agenzia.getCitta());
				tmpList.indirizzo.set(agenzia.getIndirizzo());
				listaAgenzia.add(tmpList);
			}
			
		}
		
	}
	
	/**Controlla se l'username scelto è già esistente 
	 * nel sistema
	 * 
	 * @param username da cercare
	 * @return boolean di risposta
	 */
	public boolean existsAccount(String username){
		ArrayList<String> list = new ArrayList<>();
		request = new ComplexRequest();
		FrontController frontController = new DefaultFrontController();
		request.setType(RequestType.SERVICE);
		request.setRequest("existsAccount");
		list.add(username);
		request.setParameters(list);
		BasicResponse response = (BasicResponse)frontController.processRequest(request);
		boolean exists = response.isResponse();
		return exists;
		
	}
	
	
	
	

}
