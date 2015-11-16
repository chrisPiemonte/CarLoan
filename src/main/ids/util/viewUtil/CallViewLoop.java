package main.ids.util.viewUtil;

import main.ids.presentation.DefaultFrontController;
import main.ids.presentation.FrontController;
import main.ids.presentation.request.BasicRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.request.RequestType;

public class CallViewLoop {
	
	CallViewLoop instance = new CallViewLoop();
	
	
	public static void clientiView(){
		FrontController frontController = new DefaultFrontController();
		BasicRequest request = new BasicRequest();
		request.setRequest("gestioneCliente");
		request.setType(RequestType.VIEW);
		frontController.processRequest(request);
	}
	
	public static void contrattiView(){
		FrontController frontController = new DefaultFrontController();
		BasicRequest request = new BasicRequest();
		request.setRequest("gestioneContratti");
		request.setType(RequestType.VIEW);
		frontController.processRequest(request);
	}
	public static void autoView(){
		FrontController frontController = new DefaultFrontController();
		BasicRequest request = new BasicRequest();
		request.setType(RequestType.VIEW);
		request.setRequest("gestioneAuto");
		frontController.processRequest(request);
	}
	
	public static void fasciaView(){
		FrontController frontController = new DefaultFrontController();
		BasicRequest request = new BasicRequest();
		request.setType(RequestType.VIEW);
		request.setRequest("gestioneFascia");
		frontController.processRequest(request);
	}
	
	public static void staffView(){
		FrontController frontController = new DefaultFrontController();
		BasicRequest request = new BasicRequest();
		request.setType(RequestType.VIEW);
		request.setRequest("gestioneStaff");
		frontController.processRequest(request);
	}
	
	
	// MANAGER 
	
	
	public static void clientiViewManager(){
		FrontController frontController = new DefaultFrontController();
		BasicRequest request = new BasicRequest();
		request.setRequest("gestioneClienteManager");
		request.setType(RequestType.VIEW);
		frontController.processRequest(request);
	}
	
	public static void contrattiViewManager(){
		FrontController frontController = new DefaultFrontController();
		BasicRequest request = new BasicRequest();
		request.setRequest("gestioneContrattiManager");
		request.setType(RequestType.VIEW);
		frontController.processRequest(request);
	}
	public static void autoViewManager(){
		FrontController frontController = new DefaultFrontController();
		BasicRequest request = new BasicRequest();
		request.setType(RequestType.VIEW);
		request.setRequest("gestioneAutoManager");
		frontController.processRequest(request);
	}
	
	public static void fasciaViewManager(){
		FrontController frontController = new DefaultFrontController();
		BasicRequest request = new BasicRequest();
		request.setType(RequestType.VIEW);
		request.setRequest("gestioneFasciaManager");
		frontController.processRequest(request);
	}
	
	public static void staffViewManager(){
		FrontController frontController = new DefaultFrontController();
		BasicRequest request = new BasicRequest();
		request.setType(RequestType.VIEW);
		request.setRequest("gestioneStaffManager");
		frontController.processRequest(request);
	}
	
	
	//ADMIN 
	
	public static void clientiViewAdmin(){
		FrontController frontController = new DefaultFrontController();
		BasicRequest request = new BasicRequest();
		request.setRequest("gestioneClienteAdmin");
		request.setType(RequestType.VIEW);
		frontController.processRequest(request);
	}
	
	public static void contrattiViewAdmin(){
		FrontController frontController = new DefaultFrontController();
		BasicRequest request = new BasicRequest();
		request.setRequest("gestioneContrattiAdmin");
		request.setType(RequestType.VIEW);
		frontController.processRequest(request);
	}
	public static void autoViewAdmin(){
		FrontController frontController = new DefaultFrontController();
		BasicRequest request = new BasicRequest();
		request.setType(RequestType.VIEW);
		request.setRequest("gestioneAutoAdmin");
		frontController.processRequest(request);
	}
	
	public static void fasciaViewAdmin(){
		FrontController frontController = new DefaultFrontController();
		BasicRequest request = new BasicRequest();
		request.setType(RequestType.VIEW);
		request.setRequest("gestioneFasciaAdmin");
		frontController.processRequest(request);
	}
	
	public static void staffViewAdmin(){
		FrontController frontController = new DefaultFrontController();
		BasicRequest request = new BasicRequest();
		request.setType(RequestType.VIEW);
		request.setRequest("gestioneStaffAdmin");
		frontController.processRequest(request);
	}

}
