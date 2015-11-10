package main.ids.presentation.command.gestioneImpiegati;

import main.ids.business.applicationServices.GestioneImpiegati;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.ImpiegatoTO;

public class UpdateImpiegato implements Command  {
	
	private ComplexRequest<ImpiegatoTO> request;
	private GestioneImpiegati gestioneImpiegati;
	
	public UpdateImpiegato(Request request){
		this.gestioneImpiegati = new GestioneImpiegati();
		this.request = (ComplexRequest<ImpiegatoTO>) request;
	}
	
	@Override
	public Response execute() {

		boolean aggiornato = gestioneImpiegati.update(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(aggiornato);
		return response;
	}

}