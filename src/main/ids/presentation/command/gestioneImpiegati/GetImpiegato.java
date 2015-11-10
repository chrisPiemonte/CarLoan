package main.ids.presentation.command.gestioneImpiegati;

import main.ids.business.applicationServices.GestioneImpiegati;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.ImpiegatoTO;

public class GetImpiegato implements Command  {
	
	private ComplexRequest<String> request;
	private GestioneImpiegati gestioneImpiegati;
	
	public GetImpiegato(Request request){
		this.gestioneImpiegati = new GestioneImpiegati();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		ImpiegatoTO impiegato = gestioneImpiegati.getImpiegato(request.getParameters().get(0));
		ComplexResponse<ImpiegatoTO> response = new ComplexResponse<ImpiegatoTO>();
		response.addParameter(impiegato);
		return response;
	}

}