package main.ids.presentation.view.admin.controller;


import java.io.IOException;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.stream.Stream;

import main.ids.presentation.DefaultFrontController;
import main.ids.presentation.FrontController;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.presentation.view.controller.GestioneDatiPersonali;
import main.ids.presentation.view.controller.GestionePassword;
import main.ids.presentation.view.model.ClienteModel;
import main.ids.transferObjects.ClienteTO;
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
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CrudCliente implements Initializable {
	
	
	
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
	public TextField search;
	
	public TableView<ClienteModel> tabella;
	public TableColumn<ClienteModel, String> cf;
	public TableColumn<ClienteModel, String> nome;
	public TableColumn<ClienteModel, String> cognome;
	public TableColumn<ClienteModel, LocalDate> dataNascita;
	public TableColumn<ClienteModel, String> telefono;
	
	private ObservableList<ClienteModel> listaClienti;
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
		contratti.setOnAction(e -> CallViewLoop.contrattiViewAdmin());
		auto.setOnAction(e -> CallViewLoop.autoViewAdmin());
		clienti.setOnAction(e -> CallViewLoop.clientiViewAdmin());
		fascia.setOnAction(e -> CallViewLoop.fasciaViewAdmin());
		staff.setOnAction(e -> CallViewLoop.staffViewAdmin());
		
		aggiungi.setOnAction(e -> addCliente());
		searchButton.setOnAction(e -> cercaCliente(search.getText()));
		
		
		cf.setCellValueFactory(new PropertyValueFactory<ClienteModel, String>("cf"));
		cf.setText("Codice fiscale");
		nome.setCellValueFactory(new PropertyValueFactory<ClienteModel, String>("nome"));
		nome.setText("Nome");
		cognome.setCellValueFactory(new PropertyValueFactory<ClienteModel, String>("cognome"));
		cognome.setText("Cognome");
		dataNascita = new TableColumn<ClienteModel, LocalDate>("Data Nascita");
		dataNascita.setCellValueFactory(new PropertyValueFactory<ClienteModel, LocalDate>("dataNascita"));
		telefono.setCellValueFactory(new PropertyValueFactory<ClienteModel, String>("telefono"));
		telefono.setText("Numero di telefono");
		
		buildData();
		
		//tabella.getSelectionModel().selectedIndexProperty().addListener();
	}
	
	
	private void addCliente(){
		try {
		ViewsJsonParser vjp = ViewsJsonParser.getInstance();
	    FXMLLoader loader = new FXMLLoader(getClass().getResource(vjp.getViewPath("inserisciClienteAdmin")));  
	    Parent root = (Parent) loader.load();  
	    Scene scene = new Scene(root,600,500);  
	    Stage stage = new Stage();  
	    stage.setScene(scene);  
	    stage.setTitle("Inserisci Cliente");
	    stage.initModality(Modality.APPLICATION_MODAL);    
	    stage.show();  
		}catch (IOException | NullPointerException e) {
			
			e.printStackTrace();
			

		}
	}
	
	
	
	
	public void buildData(){
		listaClienti = FXCollections.observableArrayList();
		ComplexRequest request = new ComplexRequest();
		request.setRequest("getAllClienti");
		request.setType(RequestType.SERVICE);
		ComplexResponse<ClienteTO> response = (ComplexResponse<ClienteTO>) frontController.processRequest(request);
		for (ClienteTO cliente : response.getParameters()){
			
			ClienteModel tmpList = new ClienteModel();
			tmpList.cf.set(cliente.getCf());
			tmpList.nome.set(cliente.getNome());
			tmpList.cognome.set(cliente.getCognome());
			tmpList.dataNascita.set(cliente.getDataNascita().toString());
			tmpList.telefono.set(cliente.getTelefono());
			listaClienti.add(tmpList);
			
		}
		
		tabella.setItems(listaClienti);
		tabella.getColumns().add(dataNascita);
		//System.out.println(listaClienti.get(0).getCf());
	}
	
	
	public void cercaCliente(String key){
		if (key.equals("")){tabella.setItems(listaClienti);}
		FilteredList <ClienteModel> filteredData = new FilteredList<>(listaClienti, p->p.getCognome().toLowerCase().startsWith(key));
		tabella.setItems(filteredData);
	}
	
	
	
		
		
		
	



}
