package main.ids.presentation.view.controller;
  
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import main.ids.presentation.CurrentSessionHandler;
import main.ids.presentation.FrontController;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.presentation.view.model.ClienteModel;
import main.ids.presentation.view.model.ContrattiModel;
import main.ids.transferObjects.ClienteTO;
import main.ids.transferObjects.ContrattoTO;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
	public Button chiudi;
	public Button apri;
	
	
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
		
		clienti.setOnAction(e -> CallViewLoop.clientiView());
		contratti.setOnAction(e -> CallViewLoop.contrattiView());
		autoView.setOnAction(e -> CallViewLoop.autoView());
		fascia.setOnAction(e -> CallViewLoop.fasciaView());
		staff.setOnAction(e -> CallViewLoop.staffView());
		searchButton.setOnAction(e -> cercaCliente(search.getText()));
		chiudi.setDisable(true);
		apri.setOnAction(e -> apriContratto());
		
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
		
		
		tabella.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue) -> {
			if(newValue.getStatoContratto().equals("aperto") && newValue.getAgenziaFine().equals(CurrentSessionHandler.getAgenzia()))
				chiudi.setDisable(false);
			else
				chiudi.setDisable(true);
			chiudi.setOnAction(e -> System.out.println(newValue.getId()));
			
		});
		
		
		
		
	}
	
	
	public void buildData(){
		listaContratti= FXCollections.observableArrayList();
		ComplexRequest request = new ComplexRequest();
		request.setRequest("getAllContratti");
		request.setType(RequestType.SERVICE);
		ComplexResponse<ContrattoTO> response = (ComplexResponse<ContrattoTO>) frontController.processRequest(request);
		for (ContrattoTO contratto : response.getParameters()){
			
			ContrattiModel tmpList = new ContrattiModel();
			tmpList.id.set(contratto.getId());
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
			tmpList.agenziaFine.set(contratto.getAgenziaFine());
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
	
	
	public boolean chiudiContratto(String id){
		return true;
	}
	
	private void apriContratto(){
		try {
		ViewsJsonParser vjp = ViewsJsonParser.getInstance();
		String path = vjp.getViewPath("apriContratto");
	    FXMLLoader loader = new FXMLLoader(getClass().getResource(path));  
	    Parent root = (Parent) loader.load();  
	    Scene scene = new Scene(root,600,500);  
	    Stage stage = new Stage();  
	    stage.setScene(scene);  
	    stage.setTitle("Apri Contratto");
	    stage.initModality(Modality.APPLICATION_MODAL);    
	    stage.show();  
		}catch (IOException | NullPointerException e) {
			
			e.printStackTrace();
			

		}
	}
	
	

}