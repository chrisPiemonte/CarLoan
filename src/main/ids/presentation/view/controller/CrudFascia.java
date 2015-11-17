package main.ids.presentation.view.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import main.ids.presentation.DefaultFrontController;
import main.ids.presentation.FrontController;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.presentation.view.model.AutoModel;
import main.ids.presentation.view.model.ClienteModel;
import main.ids.presentation.view.model.FasciaModel;
import main.ids.transferObjects.AutoTO;
import main.ids.transferObjects.FasciaTO;
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
/**Controller per la view delle interfacce relative alle macchine 
 * 
 * @author bi
 *
 */
public class CrudFascia implements Initializable {
	
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
	public Button searchButton;
	public TextField search;
	public MenuButton personalMenu;
	
	
	public TableView<FasciaModel> tabella;
	public TableColumn<FasciaModel, String> id;
	public TableColumn<FasciaModel, String> descrizione;
	public TableColumn<FasciaModel, Double> tariffaGiornaliera;
	public TableColumn<FasciaModel, Double> tariffaSettimanale;
	public TableColumn<FasciaModel, Double> tariffaKm;
	
	private ObservableList<FasciaModel> listaFasce;
	
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
		//fascia.setOnAction(e -> callFasciaView());
		staff.setOnAction(e -> CallViewLoop.staffView());
		
		searchButton.setOnAction(e -> cercaFascia(search.getText()));
		
		id.setCellValueFactory(new PropertyValueFactory<FasciaModel, String>("id"));
		id.setText("Id");
		descrizione.setCellValueFactory(new PropertyValueFactory<FasciaModel, String>("descrizione"));
		descrizione.setText("Descrizione");
		tariffaGiornaliera.setCellValueFactory(new PropertyValueFactory<FasciaModel, Double>("tariffaGiornaliera"));
		tariffaGiornaliera.setText("T. gioraliera");
		tariffaSettimanale.setCellValueFactory(new PropertyValueFactory<FasciaModel, Double>("tariffaSettimanale"));
		tariffaSettimanale.setText("T. settimanale");
		tariffaKm.setCellValueFactory(new PropertyValueFactory<FasciaModel, Double>("tariffaKm"));
		tariffaKm.setText("T. chilometraggio");
		
		buildData();
		
		
		
		
	}
	
	/**Costruzione de i dati presenti in tabella prelevati 
	 * dal database di sistema.
	 * Organizzati in base al {@link FasciaModel}
	 * 
	 */
	
	public void buildData(){
		listaFasce  = FXCollections.observableArrayList();
		ComplexRequest request = new ComplexRequest();
		request.setRequest("getAllFasce");
		request.setType(RequestType.SERVICE);
		ComplexResponse<FasciaTO> response = (ComplexResponse<FasciaTO>) frontController.processRequest(request);
		for (FasciaTO fascia : response.getParameters()){
			
			FasciaModel tmpList = new FasciaModel();
			tmpList.id.set(fascia.getId());
			tmpList.descrizione.set(fascia.getDescrizione());
			tmpList.tariffaGiornaliera.set(fascia.getTariffaGiornaliera());
			
			tmpList.tariffaSettimanale.set(fascia.getTariffaSettimanale());
			tmpList.tariffaKm.set(fascia.getTariffaKm());
			
			listaFasce.add(tmpList);
			
		}
		
		tabella.setItems(listaFasce);
		//System.out.println(listaClienti.get(0).getCf());
	}
	
	/**Permette la ricerca di una fascia in base alla descrizione
	 * 
	 * @param key chiave relativa la descrizione 
	 */
	public void cercaFascia(String key){
		if (key.equals("")){tabella.setItems(listaFasce);}
		FilteredList <FasciaModel> filteredData = new FilteredList<>(listaFasce, p->p.getDescrizione().toLowerCase().startsWith(key));
		tabella.setItems(filteredData);
	}
	



}