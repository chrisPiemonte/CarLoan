package main.ids.presentation.view.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import main.ids.presentation.DefaultFrontController;
import main.ids.presentation.FrontController;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.presentation.view.model.ClienteModel;
import main.ids.presentation.view.model.StaffModel;
import main.ids.transferObjects.ClienteTO;
import main.ids.transferObjects.ImpiegatoTO;
import main.ids.util.viewUtil.CallViewLoop;
import main.ids.presentation.request.BasicRequest;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.request.RequestType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
/**Controller per la gestione della View relativa allo Staff
 * con le operazioni relative
 * 
 * @author bi
 *
 */
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
	public MenuButton personalMenu;
	
	public TableView<StaffModel> tabella;
	public TableColumn<StaffModel, String> cf;
	public TableColumn<StaffModel, String> nome;
	public TableColumn<StaffModel, String> cognome;
	public TableColumn<StaffModel, LocalDate> dataNascita;
	public TableColumn<StaffModel, String> telefono;
	public TableColumn<StaffModel, String> agenzia;
	public TableColumn<StaffModel, String> username;
	
	private ObservableList<StaffModel> listaStaff;
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
		auto.setOnAction(e -> CallViewLoop.autoView());
		fascia.setOnAction(e -> CallViewLoop.fasciaView());
		searchButton.setOnAction(e -> cercaCliente(search.getText()));
		
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
	/**Permette la costruzione de i dati relativi allo staff
	 * disponendoli in tabella.
	 * Utilizza lo {@link StaffModel} per la realizzazione
	 * 
	 */
	public void buildData(){
		listaStaff = FXCollections.observableArrayList();
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
		
		tabella.setItems(listaStaff);
		//System.out.println(listaClienti.get(0).getCf());
	}
	
	/**Consente la ricerca di elementi dello staff
	 * 
	 * @param key la ricerca avviene per cognome
	 */
	public void cercaCliente(String key){
		if (key.equals("")){tabella.setItems(listaStaff);}
		FilteredList <StaffModel> filteredData = new FilteredList<>(listaStaff, p->p.getCognome().toLowerCase().startsWith(key));
		tabella.setItems(filteredData);
	}
	
	
	
	
	
}
