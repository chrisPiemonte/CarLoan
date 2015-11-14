package main.ids.presentation.view.controller;

import main.ids.presentation.FrontController;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.RequestType;
import main.ids.presentation.response.Response;

public class GestioneDatiPersonali {
	
	GestioneDatiPersonali instance = new GestioneDatiPersonali();
	
	
	public static void logout(){
		FrontController frontController = new FrontController();
		ComplexRequest request = new ComplexRequest();
		request.setType(RequestType.VIEW);
		request.setRequest("logout");
		Response response = frontController.processRequest(request);
	}

}
