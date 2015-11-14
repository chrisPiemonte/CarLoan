package main.ids.presentation.view.admin.controller;

  
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import main.ids.presentation.FrontController;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.presentation.view.model.ClienteModel;
import main.ids.presentation.view.model.ContrattiModel;
import main.ids.transferObjects.ClienteTO;
import main.ids.transferObjects.ContrattoTO;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Contratti implements Initializable {
	
	public TextField usernameInput;
	public TextField passwordInput;
	public ArrayList<String> data = new ArrayList<String>();
	public Response response;
	FrontController frontController = new FrontController();
	public Button clienti;
	public Button contratti;
	public Button autoView;
	public Button fascia;
	public Button staff;
	public Button searchButton;
	public TextField search;
	
	
	public TableView<ContrattiModel> tabella;
	public TableColumn<ContrattiModel, String> cliente;
	public TableColumn<ContrattiModel, String> auto;
	public TableColumn<ContrattiModel, String> modNoleggio;
	public TableColumn<ContrattiModel, Double> kmPercorsi;
	public TableColumn<ContrattiModel, String> statoContratto;
	public TableColumn<ContrattiModel, Double> totale;
	
	private ObservableList<ContrattiModel> listaContratti;
	
	@Override 
	public void initialize(URL location, ResourceBundle resources){
		System.out.println("Loading user data...");
		
		clienti.setOnAction(e -> CallViewLoop.clientiViewAdmin());
		contratti.setOnAction(e -> CallViewLoop.contrattiViewAdmin());
		autoView.setOnAction(e -> CallViewLoop.autoViewAdmin());
		fascia.setOnAction(e -> CallViewLoop.fasciaViewAdmin());
		staff.setOnAction(e -> CallViewLoop.staffViewAdmin());
		searchButton.setOnAction(e -> cercaCliente(search.getText()));
		
		
		cliente.setCellValueFactory(new PropertyValueFactory<ContrattiModel, String>("cliente"));
		cliente.setText("Cliente");
		auto.setCellValueFactory(new PropertyValueFactory<ContrattiModel, String>("auto"));
		auto.setText("Auto");
		modNoleggio.setCellValueFactory(new PropertyValueFactory<ContrattiModel, String>("modNoleggio"));
		modNoleggio.setText("Modalità noleggio");
		kmPercorsi.setCellValueFactory(new PropertyValueFactory<ContrattiModel, Double>("totale"));
		kmPercorsi.setText("Totale");
		statoContratto.setCellValueFactory(new PropertyValueFactory<ContrattiModel, String>("statoContratto"));
		statoContratto.setText("Stato Contratto");
		totale.setCellValueFactory(new PropertyValueFactory<ContrattiModel, Double>("totale"));
		totale.setText("Totale");
		
		buildData();
		
		
	}
	
	
	public void buildData(){
		listaContratti= FXCollections.observableArrayList();
		ComplexRequest request = new ComplexRequest();
		request.setRequest("getAllContratti");
		request.setType(RequestType.SERVICE);
		ComplexResponse<ContrattoTO> response = (ComplexResponse<ContrattoTO>) frontController.processRequest(request);
		for (ContrattoTO contratto : response.getParameters()){
			
			ContrattiModel tmpList = new ContrattiModel();
			tmpList.cliente.set(contratto.getCliente());
			tmpList.auto.set(contratto.getAuto());
			tmpList.modNoleggio.set(contratto.getModNoleggio());
			//Format formatter = new SimpleDateFormat("dd-MM-yyyy");
			//LocalDate dataNascita = cliente.getDataNascita();
			//String s = formatter.format(dataNascita);
			//tmpList.dataNascita.set(s);
			tmpList.kmPercorsi.set(contratto.getKmPercorsi());
			tmpList.statoContratto.set(contratto.getStatoContratto());
			tmpList.totale.set(contratto.getTotale());
			listaContratti.add(tmpList);
			
		}
		
		tabella.setItems(listaContratti);
		//System.out.println(listaClienti.get(0).getCf());
	}
	
	public void cercaCliente(String key){
		if (key.equals("")){tabella.setItems(listaContratti);}
		FilteredList <ContrattiModel> filteredData = new FilteredList<>(listaContratti, p->p.getCliente().toLowerCase().startsWith(key));
		tabella.setItems(filteredData);
	}
	
	

}
