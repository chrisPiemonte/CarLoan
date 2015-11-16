package main.ids.presentation.view.manager.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import main.ids.presentation.CurrentSessionHandler;
import main.ids.presentation.DefaultFrontController;
import main.ids.presentation.FrontController;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.presentation.view.controller.GestioneDatiPersonali;
import main.ids.presentation.view.controller.GestionePassword;
import main.ids.presentation.view.model.ClienteModel;
import main.ids.presentation.view.model.StaffModel;
import main.ids.transferObjects.ClienteTO;
import main.ids.transferObjects.ImpiegatoTO;
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
	
	public TableView<StaffModel> tabella;
	public TableColumn<StaffModel, String> cf;
	public TableColumn<StaffModel, String> nome;
	public TableColumn<StaffModel, String> cognome;
	public TableColumn<StaffModel, LocalDate> dataNascita;
	public TableColumn<StaffModel, String> telefono;
	public TableColumn<StaffModel, String> agenzia;
	public TableColumn<StaffModel, String> username;
	public MenuButton personalMenu;
	private FilteredList<StaffModel> listaStaff;
	private ObservableList<StaffModel> tmp;
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
		clienti.setOnAction(e -> CallViewLoop.clientiViewManager());
		contratti.setOnAction(e -> CallViewLoop.contrattiViewManager());
		auto.setOnAction(e -> CallViewLoop.autoViewManager());
		fascia.setOnAction(e -> CallViewLoop.fasciaViewManager());
		staff.setOnAction(e -> CallViewLoop.staffViewManager());
		searchButton.setOnAction(e -> cercaCliente(search.getText()));
		aggiungi.setOnAction(e -> addStaff());
		
		cf.setCellValueFactory(new PropertyValueFactory<StaffModel, String>("cf"));
		cf.setText("Codice fiscale");
		nome.setCellValueFactory(new PropertyValueFactory<StaffModel, String>("nome"));
		nome.setText("Nome");
		cognome.setCellValueFactory(new PropertyValueFactory<StaffModel, String>("cognome"));
		cognome.setText("Cognome");
		telefono.setCellValueFactory(new PropertyValueFactory<StaffModel, String>("telefono"));
		telefono.setText("Numero telefono");
		agenzia.setCellValueFactory(new PropertyValueFactory<StaffModel, String>("agenzia"));
		agenzia.setText("Agenzia");
		username.setCellValueFactory(new PropertyValueFactory<StaffModel, String>("username"));
		username.setText("Username");
		dataNascita.setCellValueFactory(new PropertyValueFactory<StaffModel, LocalDate>("dataNascita"));
		dataNascita.setText("Data Nascita");
		
		buildData();
		
	}
	
	public void buildData(){
		tmp = FXCollections.observableArrayList();
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
			tmp.add(tmpList);
			
		}
		listaStaff = new FilteredList<>(tmp, p-> p.getAgenzia().equals(CurrentSessionHandler.getAgenzia()));
		
		tabella.setItems(listaStaff);
		//System.out.println(listaClienti.get(0).getCf());
	}
	
	public void cercaCliente(String key){
		if (key.equals("")){tabella.setItems(listaStaff);}
		FilteredList <StaffModel> filteredData = new FilteredList<>(listaStaff, p->p.getCognome().toLowerCase().startsWith(key));
		tabella.setItems(filteredData);
	}
	
	private void addStaff(){
		try {
		ViewsJsonParser vjp = ViewsJsonParser.getInstance();
	    FXMLLoader loader = new FXMLLoader(getClass().getResource(vjp.getViewPath("inserisciStaffManager")));  
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
