package main.ids.presentation.view.controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.ids.presentation.DefaultFrontController;
import main.ids.presentation.FrontController;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.RequestType;
import main.ids.presentation.response.Response;
import main.ids.util.json.ViewsJsonParser;

public class GestioneDatiPersonali {
	
	GestioneDatiPersonali instance = new GestioneDatiPersonali();
	
	
	public static void logout(){
		FrontController frontController = new DefaultFrontController();
		ComplexRequest request = new ComplexRequest();
		request.setType(RequestType.VIEW);
		request.setRequest("logout");
		Response response = frontController.processRequest(request);
	}
	
	
	

}
