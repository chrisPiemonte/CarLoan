package main.ids.presentation.command.gestioneManager;

import main.ids.business.applicationServices.GestioneManager;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;

public class ExistsManager implements Command  {
	
	private ComplexRequest<String> request;
	private GestioneManager gestioneManager;
	
	public ExistsManager(Request request){
		this.gestioneManager = new GestioneManager();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		boolean esiste = gestioneManager.exists(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(esiste);
		return response;
	}

}