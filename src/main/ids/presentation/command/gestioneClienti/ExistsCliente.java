package main.ids.presentation.command.gestioneClienti;

import main.ids.business.applicationServices.GestioneClienti;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;

public class ExistsCliente implements Command  {
	

	private ComplexRequest<String> request;
	private GestioneClienti gestioneClienti;
	
	
	public ExistsCliente(Request request){
		this.gestioneClienti = new GestioneClienti();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		boolean esiste = gestioneClienti.exists(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(esiste);
		return response;
	}

}