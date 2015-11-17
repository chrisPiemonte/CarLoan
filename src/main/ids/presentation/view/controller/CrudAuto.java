package main.ids.presentation.view.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import main.ids.presentation.CurrentSessionHandler;
import main.ids.presentation.DefaultFrontController;
import main.ids.presentation.FrontController;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.presentation.view.controller.InputBox;
import main.ids.presentation.view.model.AutoModel;
import main.ids.presentation.view.model.ClienteModel;
import main.ids.transferObjects.AutoTO;
import main.ids.transferObjects.ClienteTO;
import main.ids.util.viewUtil.CallViewLoop;
import main.ids.presentation.request.BasicRequest;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.request.RequestType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**Controller per la view di auto 
 * con all'interno dati e operazioni relative
 * 
 * @author bi
 *
 */
public class CrudAuto implements Initializable {
	
	public TextField usernameInput;
	public TextField passwordInput;
	public ArrayList<String> data = new ArrayList<String>();
	public Response response;
	FrontController frontController = new DefaultFrontController();
	public Button clienti;
	public Button contratti;
	public Button auto;
	public Button fascia;
	public Button staff;
	public Button aggiungi;
	public Button cancella;
	public Button searchButton;
	public Button cambiaKm;
	public Button cambiaStato;
	
	public TextField search;
	
	
	public TableView<AutoModel> tabella;
	public TableColumn<AutoModel, String> targa;
	public TableColumn<AutoModel, String> modello;
	public TableColumn<AutoModel, String> stato;
	public TableColumn<AutoModel, String> fasciaAuto;
	public TableColumn<AutoModel, Double> km;
	public TableColumn<AutoModel, LocalDate> manutenzioneOrdinaria;
	public TableColumn<AutoModel, String> agenzia;
	
	private ObservableList<AutoModel> listaAuto;
	
	public MenuButton personalMenu;
	
	@Override 
	public void initialize(URL location, ResourceBundle resources){
		
		MenuItem logout = new MenuItem("Logout");
		MenuItem cambiaPass = new MenuItem("Cambia Password...");
		logout.setOnAction(e -> GestioneDatiPersonali.logout());
		cambiaPass.setOnAction(e -> {
		
			GestionePassword i = new GestionePassword();
			i.cambiaPassword();
		});
		personalMenu.getItems().addAll(cambiaPass,logout);
		clienti.setOnAction(e -> CallViewLoop.clientiView());
		contratti.setOnAction(e -> CallViewLoop.contrattiView());
		//auto.setOnAction(e -> callAutoView());
		fascia.setOnAction(e -> CallViewLoop.fasciaView());
		staff.setOnAction(e -> CallViewLoop.staffView());
		cambiaStato.setDisable(true);
		cambiaKm.setDisable(true);
		
		
		searchButton.setOnAction(e -> cercaAuto(search.getText()));
		
		targa.setCellValueFactory(new PropertyValueFactory<AutoModel, String>("targa"));
		targa.setText("Targa");
		modello.setCellValueFactory(new PropertyValueFactory<AutoModel, String>("modello"));
		modello.setText("Modello");
		stato.setCellValueFactory(new PropertyValueFactory<AutoModel, String>("stato"));
		stato.setText("Stato");
		fasciaAuto.setCellValueFactory(new PropertyValueFactory<AutoModel, String>("fasciaAuto"));
		fasciaAuto.setText("Fascia");
		km.setCellValueFactory(new PropertyValueFactory<AutoModel, Double>("km"));
		km.setText("km");
		manutenzioneOrdinaria.setCellValueFactory(new PropertyValueFactory<AutoModel, LocalDate>("manutenzioneOrdinaria"));
		manutenzioneOrdinaria.setText("Data manutenzione");
		agenzia.setCellValueFactory(new PropertyValueFactory<AutoModel, String>("agenzia"));
		agenzia.setText("Agenzia");
		
		buildData();
		
		tabella.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue) -> {
			cambiaStato.setDisable(false);
			cambiaKm.setDisable(false);
			cambiaStato.setOnAction(e -> setStatoAuto(newValue.getTarga()));
			cambiaKm.setOnAction(e -> setKmAuto(newValue.getTarga()));
		});
	}
	
	
	/**Permette la costruzioni de i dati basati sul {@link AutoModel}
	 * 
	 */
	public void buildData(){
		listaAuto = FXCollections.observableArrayList();
		ComplexRequest request = new ComplexRequest();
		ArrayList<String> checkAgenzia = new ArrayList<String>();
		checkAgenzia.add(CurrentSessionHandler.getAgenzia());
		request.setRequest("getAutoByAgenzia");
		request.setParameters(checkAgenzia);
		request.setType(RequestType.SERVICE);
		ComplexResponse<AutoTO> response = (ComplexResponse<AutoTO>) frontController.processRequest(request);
		for (AutoTO cliente : response.getParameters()){
			
			AutoModel tmpList = new AutoModel();
			tmpList.targa.set(cliente.getTarga());
			tmpList.modello.set(cliente.getModello());
			tmpList.stato.set(cliente.getStato());
			tmpList.fasciaAuto.set(cliente.getFascia());
			tmpList.km.set(cliente.getKm());
			tmpList.manutenzioneOrdinaria.set(cliente.getManutenzioneOrdinaria().toString());
			tmpList.agenzia.set(cliente.getAgenzia());
			listaAuto.add(tmpList);
			
		}
		
		tabella.setItems(listaAuto);
		//System.out.println(listaClienti.get(0).getCf());
	}
	
	/**Tasto per la ricerca di macchine all interno della view
	 * 
	 * @param key la chiave di ricerca è il modello 
	 */
	public void cercaAuto(String key){
		if (key.equals("")){tabella.setItems(listaAuto);}
		FilteredList <AutoModel> filteredData = new FilteredList<>(listaAuto, p->p.getModello().toLowerCase().startsWith(key));
		tabella.setItems(filteredData);
	}
	
	/**Imposta un nuovo stato per un auto selezionata
	 * 
	 * @param targa targa dell auto selezionata
	 */
	public void setStatoAuto(String targa){
		
		String newStato = InputBox.displayStato("");
		if (!newStato.equals("null")){
			frontController = new DefaultFrontController();
			ComplexRequest request = new ComplexRequest();
			ArrayList<String> list = new ArrayList();
			list.add(targa);
			list.add(newStato);
			request.setRequest("changeStatoOfAuto");
			request.setType(RequestType.SERVICE);
			request.setParameters(list);
			BasicResponse response = (BasicResponse) frontController.processRequest(request);
			if (response.isResponse()){
				request = new ComplexRequest();
				request.setRequest("gestioneAuto");
				request.setType(RequestType.VIEW);
				frontController.processRequest(request);
			} else {
				Message.display("Stato non cambiato", AlertType.ERROR);
			}
			
		}
	
	}
	/**Imposta un nuovo chilometraggio
	 *  
	 * @param targa la targa dell'auto selezionata
	 */
	
	public void setKmAuto(String targa){
		String newStato = InputBox.display("Inserire nuovo chilometraggio");
		double value = Double.parseDouble(newStato) ;
		if (! (value == 0)){
			frontController = new DefaultFrontController();
			ComplexRequest request = new ComplexRequest();
			ArrayList<Object> list = new ArrayList();
			list.add(targa);
			list.add(value);
			request.setRequest("changeKmOfAuto");
			request.setType(RequestType.SERVICE);
			request.setParameters(list);
			BasicResponse response = (BasicResponse) frontController.processRequest(request);
			if (response.isResponse()){
				request = new ComplexRequest();
				request.setRequest("gestioneAuto");
				request.setType(RequestType.VIEW);
				frontController.processRequest(request);
			} else {
				Message.display("chilometri non cambiati", AlertType.ERROR);
			}
			
		}
	
	}



}
