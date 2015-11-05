package main.ids.presentation.command;

import main.ids.presentation.response.Response;
import main.ids.presentation.request.Request;


public class Command {
	
	String name;
	Response response = new Response();
	
	public Command(){
		this.name = "";

		
	}
	
	public Response execute(Request request){
		
		if(request.getRequest().equals("login")){
			if (request.getParameters().get(0).equals("gino") && request.getParameters().get(1).equals("gino"))
				
				response.setResponse(true);
		}
		
		return response;
		
		
		
	}

}
