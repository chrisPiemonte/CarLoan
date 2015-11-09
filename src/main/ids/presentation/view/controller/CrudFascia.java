package main.ids.presentation.view.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import main.ids.presentation.FrontController;
import main.ids.presentation.response.Response;
import main.ids.presentation.request.BasicRequest;
import main.ids.presentation.request.Request;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CrudFascia implements Initializable {
	
	public TextField usernameInput;
	public TextField passwordInput;
	public ArrayList<String> data = new ArrayList<String>();
	public Response response;
	FrontController frontController = new FrontController();
	public Button clienti;
	public Button contratti;
	public Button auto;
	public Button fascia;
	public Button staff;
	public Button aggiungi;
	public Button cancella;
	
	@Override 
	public void initialize(URL location, ResourceBundle resources){
		System.out.println("Loading user data...");
		
		clienti.setOnAction(e -> callClientiView());
		contratti.setOnAction(e -> callContrattiView());
		auto.setOnAction(e -> callAutoView());
		//fascia.setOnAction(e -> callFasciaView());
		staff.setOnAction(e -> callStaffView());
		
		aggiungi.setOnAction(e -> addFascia());
		
		
		
	}
	
	
	private void callClientiView(){
		Request request = new BasicRequest();
		request.setRequest("gestioneCliente");
		frontController.processRequest(request);
	}
	
	private void callContrattiView(){
		Request request = new BasicRequest();
		request.setRequest("gestioneContratti");
		frontController.processRequest(request);
	}
	
	private void callAutoView(){
		Request request = new BasicRequest();
		request.setRequest("gestioneAuto");
		frontController.processRequest(request);
	}

/*
	private void callFasciaView(){
		Request request = new BasicRequest();
		request.setRequest("gestioneFascia");
		frontController.processRequest(request);
	}
*/	

	private void callStaffView(){
		Request request = new BasicRequest();
		request.setRequest("gestioneStaff");
		frontController.processRequest(request);
	}
	
	
	private void addFascia(){
		try {
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/ids/presentation/view/InserisciFasciaPopUp.fxml"));  
	    Parent root = (Parent) loader.load();  
	    Scene scene = new Scene(root,600,500);  
	    Stage stage = new Stage();  
	    stage.setScene(scene);  
	    stage.setTitle("Inserisci Fascia");
	    stage.initModality(Modality.APPLICATION_MODAL);    
	    stage.show();  
		}catch (IOException | NullPointerException e) {
			
			e.printStackTrace();
			

		}
	}
	

	



}