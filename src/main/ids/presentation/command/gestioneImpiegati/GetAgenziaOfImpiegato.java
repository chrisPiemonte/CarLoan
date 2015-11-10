package main.ids.presentation.command.gestioneImpiegati;

import main.ids.business.applicationServices.GestioneImpiegati;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;

public class GetAgenziaOfImpiegato implements Command  {
	
	private ComplexRequest<String> request;
	private GestioneImpiegati gestioneImpiegati;
	
	public GetAgenziaOfImpiegato(Request request){
		this.gestioneImpiegati = new GestioneImpiegati();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		String agenziaId = gestioneImpiegati.getAgenziaOf(request.getParameters().get(0));
		ComplexResponse<String> response = new ComplexResponse<String>();
		response.addParameter(agenziaId);
		return response;
	}

}