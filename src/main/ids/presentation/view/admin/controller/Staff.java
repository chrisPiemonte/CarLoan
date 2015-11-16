package main.ids.presentation.view.admin.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import main.ids.presentation.CurrentSessionHandler;
import main.ids.presentation.DefaultFrontController;
import main.ids.presentation.FrontController;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.presentation.view.controller.GestioneDatiPersonali;
import main.ids.presentation.view.controller.GestionePassword;
import main.ids.presentation.view.model.AgenziaModel;
import main.ids.presentation.view.model.ClienteModel;
import main.ids.presentation.view.model.StaffModel;
import main.ids.transferObjects.AgenziaTO;
import main.ids.transferObjects.ClienteTO;
import main.ids.transferObjects.ImpiegatoTO;
import main.ids.transferObjects.ManagerTO;
import main.ids.util.json.ViewsJsonParser;
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
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Staff implements Initializable {
	
	public TextField usernameInput;
	public TextField passwordInput;
	public ArrayList<String> data = new ArrayList<String>();
	public Response response;
	FrontController frontController = new DefaultFrontController();
	public Button clienti;
	public Button contratti;
	public Button auto;
	public Button fascia;
	public Button searchButton;
	public TextField search;
	public Button staff;
	public Button aggiungi;
	public Button aggiungiAgenzia;
	
	public TableView<StaffModel> tabella;
	public TableColumn<StaffModel, String> cf;
	public TableColumn<StaffModel, String> nome;
	public TableColumn<StaffModel, String> cognome;
	public TableColumn<StaffModel, LocalDate> dataNascita;
	public TableColumn<StaffModel, String> telefono;
	public TableColumn<StaffModel, String> agenzia;
	public TableColumn<StaffModel, String> username;
	
	public TableView<AgenziaModel> tabellaAgenzie;
	public TableColumn<AgenziaModel, String> id;
	public TableColumn<AgenziaModel, String> città;
	public TableColumn<AgenziaModel, String> indirizzo;
	public TableColumn<AgenziaModel, String> telefonoAgenzia;
	
	private ObservableList<AgenziaModel> listaAgenzie;
	private ObservableList<StaffModel> listaStaff;
	private ObservableList<StaffModel> listaManager;
	private ObservableList<StaffModel> listaAllStaff;
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
		clienti.setOnAction(e -> CallViewLoop.clientiViewAdmin());
		contratti.setOnAction(e -> CallViewLoop.contrattiViewAdmin());
		auto.setOnAction(e -> CallViewLoop.autoViewAdmin());
		fascia.setOnAction(e -> CallViewLoop.fasciaViewAdmin());
		staff.setOnAction(e -> CallViewLoop.staffViewAdmin());
		searchButton.setOnAction(e -> cercaCliente(search.getText()));
		aggiungi.setOnAction(e -> addStaff());
		aggiungiAgenzia.setOnAction(e -> addAgenzia());
		
		cf.setCellValueFactory(new PropertyValueFactory<StaffModel, String>("cf"));
		cf.setText("Codice fiscale");
		nome.setCellValueFactory(new PropertyValueFactory<StaffModel, String>("nome"));
		nome.setText("Nome");
		cognome.setCellValueFactory(new PropertyValueFactory<StaffModel, String>("cognome"));
		cognome.setText("Cognome");
		telefono.setCellValueFactory(new PropertyValueFactory<StaffModel, String>("telefono"));
		telefono.setText("Numero telefono");
		dataNascita.setCellValueFactory(new PropertyValueFactory<StaffModel, LocalDate>("dataNascita"));
		dataNascita.setText("Data Nascita");
		agenzia.setCellValueFactory(new PropertyValueFactory<StaffModel, String>("agenzia"));
		agenzia.setText("Agenzia");
		username.setCellValueFactory(new PropertyValueFactory<StaffModel, String>("username"));
		username.setText("Username");
		
		id = new TableColumn<AgenziaModel, String>("ID agenzia");
		id.setCellValueFactory(new PropertyValueFactory<AgenziaModel, String>("id"));
		indirizzo = new TableColumn<AgenziaModel, String>("Indirizzo");
		indirizzo.setCellValueFactory(new PropertyValueFactory<AgenziaModel, String>("indirizzo"));
		città = new TableColumn<AgenziaModel, String>("Città");
		città.setCellValueFactory(new PropertyValueFactory<AgenziaModel, String>("città"));
		telefonoAgenzia = new TableColumn<AgenziaModel, String>("Telefono");
		telefonoAgenzia.setCellValueFactory(new PropertyValueFactory<AgenziaModel, String>("telefono"));

		buildData();
		tabellaAgenzie.getColumns().addAll(id,indirizzo,città,telefonoAgenzia);
		
	}
	
	public void buildData(){
		listaStaff = FXCollections.observableArrayList();
		listaAgenzie = FXCollections.observableArrayList();
		listaManager = FXCollections.observableArrayList();
		listaAllStaff = FXCollections.observableArrayList();
		ComplexRequest request = new ComplexRequest();
		request.setRequest("getAllImpiegati");
		request.setType(RequestType.SERVICE);
		ComplexResponse<ImpiegatoTO> response = (ComplexResponse<ImpiegatoTO>) frontController.processRequest(request);
		for (ImpiegatoTO staff : response.getParameters()){
			
			StaffModel tmpList = new StaffModel();
			tmpList.cf.set(staff.getCf());
			tmpList.nome.set(staff.getNome());
			tmpList.cognome.set(staff.getCognome());
			tmpList.dataNascita.set(staff.getDataNascita().toString());
			tmpList.telefono.set(staff.getTelefono());
			tmpList.agenzia.set(staff.getAgenzia());
			tmpList.username.set(staff.getUsername());
			listaStaff.add(tmpList);
			
			
		}
		request = new ComplexRequest();
		request.setType(RequestType.SERVICE);
		request.setRequest("getAllManagers");
		ComplexResponse<ImpiegatoTO> responseManager = (ComplexResponse<ImpiegatoTO>) frontController.processRequest(request);
		for (ImpiegatoTO manager : responseManager.getParameters()){
			StaffModel tmpList = new StaffModel();
			tmpList.cf.set(manager.getCf());
			tmpList.nome.set(manager.getNome());
			tmpList.cognome.set(manager.getCognome());
			tmpList.dataNascita.set(manager.getDataNascita().toString());
			tmpList.telefono.set(manager.getTelefono());
			tmpList.username.set(manager.getTelefono());
			tmpList.agenzia.set(manager.getAgenzia());
			listaManager.add(tmpList);
			
		}
		
		
		tabella.setItems(listaStaff);

		// agenzie
		
		request = new ComplexRequest();
		request.setType(RequestType.SERVICE);
		request.setRequest("getAllAgenzie");
		ComplexResponse<AgenziaTO> response2 = (ComplexResponse<AgenziaTO>) frontController.processRequest(request);
		for (AgenziaTO agenzia : response2.getParameters()){
			AgenziaModel tmpList = new AgenziaModel();
			tmpList.id.set(agenzia.getId());
			tmpList.città.set(agenzia.getCitta());
			tmpList.indirizzo.set(agenzia.getIndirizzo());
			tmpList.telefonoAgenzia.set(agenzia.getTelefono());
			listaAgenzie.add(tmpList);
		}
		
		tabellaAgenzie.setItems(listaAgenzie);
	}
	
	public void cercaCliente(String key){
		if (key.equals("")){tabella.setItems(listaStaff);}
		FilteredList <StaffModel> filteredData = new FilteredList<>(listaStaff, p->p.getCognome().toLowerCase().startsWith(key));
		tabella.setItems(filteredData);
	}
	
	private void addStaff(){
		try {
		ViewsJsonParser vjp = ViewsJsonParser.getInstance();
	    FXMLLoader loader = new FXMLLoader(getClass().getResource(vjp.getViewPath("inserisciStaffAdmin")));  
	    Parent root = (Parent) loader.load();  
	    Scene scene = new Scene(root,600,500);  
	    Stage stage = new Stage();  
	    stage.setScene(scene);  
	    stage.setTitle("Inserisci Staff");
	    stage.initModality(Modality.APPLICATION_MODAL);    
	    stage.show();  
		}catch (IOException | NullPointerException e) {
			
			e.printStackTrace();
			

		}
	
	
	
	
	}
	private void addAgenzia(){
		try {
		ViewsJsonParser vjp = ViewsJsonParser.getInstance();
	    FXMLLoader loader = new FXMLLoader(getClass().getResource(vjp.getViewPath("inserisciAgenziaAdmin")));  
	    Parent root = (Parent) loader.load();  
	    Scene scene = new Scene(root,600,500);  
	    Stage stage = new Stage();  
	    stage.setScene(scene);  
	    stage.setTitle("Inserisci Staff");
	    stage.initModality(Modality.APPLICATION_MODAL);    
	    stage.show();  
		}catch (IOException | NullPointerException e) {
			
			e.printStackTrace();
			

		}
	
	
	
	
	}	
}
