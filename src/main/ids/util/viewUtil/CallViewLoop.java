package main.ids.util.viewUtil;

import main.ids.presentation.FrontController;
import main.ids.presentation.request.BasicRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.request.RequestType;

public class CallViewLoop {
	
	CallViewLoop instance = new CallViewLoop();
	
	
	public static void clientiView(){
		FrontController frontController = new FrontController();
		BasicRequest request = new BasicRequest();
		request.setRequest("gestioneCliente");
		request.setType(RequestType.VIEW);
		frontController.processRequest(request);
	}
	
	public static void contrattiView(){
		FrontController frontController = new FrontController();
		BasicRequest request = new BasicRequest();
		request.setRequest("gestioneContratti");
		request.setType(RequestType.VIEW);
		frontController.processRequest(request);
	}
	public static void autoView(){
		FrontController frontController = new FrontController();
		BasicRequest request = new BasicRequest();
		request.setType(RequestType.VIEW);
		request.setRequest("gestioneAuto");
		frontController.processRequest(request);
	}
	
	public static void fasciaView(){
		FrontController frontController = new FrontController();
		BasicRequest request = new BasicRequest();
		request.setType(RequestType.VIEW);
		request.setRequest("gestioneFascia");
		frontController.processRequest(request);
	}
	
	public static void staffView(){
		FrontController frontController = new FrontController();
		BasicRequest request = new BasicRequest();
		request.setType(RequestType.VIEW);
		request.setRequest("gestioneStaff");
		frontController.processRequest(request);
	}
	
	
	// MANAGER 
	
	
	public static void clientiViewManager(){
		FrontController frontController = new FrontController();
		BasicRequest request = new BasicRequest();
		request.setRequest("gestioneClienteManager");
		request.setType(RequestType.VIEW);
		frontController.processRequest(request);
	}
	
	public static void contrattiViewManager(){
		FrontController frontController = new FrontController();
		BasicRequest request = new BasicRequest();
		request.setRequest("gestioneContrattiManager");
		request.setType(RequestType.VIEW);
		frontController.processRequest(request);
	}
	public static void autoViewManager(){
		FrontController frontController = new FrontController();
		BasicRequest request = new BasicRequest();
		request.setType(RequestType.VIEW);
		request.setRequest("gestioneAutoManager");
		frontController.processRequest(request);
	}
	
	public static void fasciaViewManager(){
		FrontController frontController = new FrontController();
		BasicRequest request = new BasicRequest();
		request.setType(RequestType.VIEW);
		request.setRequest("gestioneFasciaManager");
		frontController.processRequest(request);
	}
	
	public static void staffViewManager(){
		FrontController frontController = new FrontController();
		BasicRequest request = new BasicRequest();
		request.setType(RequestType.VIEW);
		request.setRequest("gestioneStaffManager");
		frontController.processRequest(request);
	}

}
