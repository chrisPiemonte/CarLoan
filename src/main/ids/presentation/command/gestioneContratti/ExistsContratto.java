package main.ids.presentation.command.gestioneContratti;

import main.ids.business.applicationServices.GestioneContratti;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;

public class ExistsContratto implements Command  {
	
	private ComplexRequest<String> request;
	private GestioneContratti gestioneContratti;
	
	public ExistsContratto(Request request){
		this.gestioneContratti = new GestioneContratti();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {
		boolean esiste = gestioneContratti.exists(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(esiste);
		return response;
	}

}