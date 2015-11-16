package main.ids.presentation;



import main.ids.presentation.request.Request;
import main.ids.presentation.response.Response;


import java.util.ArrayList;

import main.ids.presentation.ApplicationController;

public class DefaultFrontController implements FrontController {
	
	ApplicationController applicationController ;
	ArrayList<String> parameters = new ArrayList<String>();
	
	
	public DefaultFrontController (){
		this.applicationController = new ApplicationController();
		
		
		
	}
	
	/*public Object processRequest(Request request){
		 applicationController.handleRequest(request);
		 return applicationController.result;
		
	}
	*/
	@Override
	public Response processRequest(Request request){
		return (Response) applicationController.handleRequest(request);
	}

}