package main.ids.presentation.view.manager.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import main.ids.presentation.FrontController;
import main.ids.presentation.response.Response;
import main.ids.util.viewUtil.CallViewLoop;
import main.ids.presentation.request.BasicRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.request.RequestType;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;

public class ManagerLogin implements Initializable {
	
	public TextField usernameInput;
	public TextField passwordInput;
	public ArrayList<String> data = new ArrayList<String>();
	public Response response;
	FrontController frontController;
	public Button clienti;
	public Button contratti;
	public Button auto;
	public Button fascia;
	public Button staff;
	
	@Override 
	public void initialize(URL location, ResourceBundle resources){
		System.out.println("Loading user data...");
		frontController = new FrontController();
		
		clienti.setOnAction(e -> CallViewLoop.clientiViewManager());
		contratti.setOnAction(e -> CallViewLoop.contrattiViewManager());
		auto.setOnAction(e -> CallViewLoop.autoViewManager());
		fascia.setOnAction(e -> CallViewLoop.fasciaViewManager());
		staff.setOnAction(e -> CallViewLoop.staffViewManager());
	}
	
	

}