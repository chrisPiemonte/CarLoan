package main.ids.presentation.command.gestioneAgenzie;

import main.ids.business.applicationServices.GestioneAgenzie;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;

public class ExistsAgenzia implements Command  {

	private ComplexRequest<String> request;
	private GestioneAgenzie gestioneAgenzie;
	
	
	public ExistsAgenzia(Request request){
		this.gestioneAgenzie = new GestioneAgenzie();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		boolean esiste = gestioneAgenzie.exists(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(esiste);
		return response;
	}

}