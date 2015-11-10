package main.ids.presentation.command.gestioneImpiegati;

import main.ids.business.applicationServices.GestioneImpiegati;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.ImpiegatoTO;

public class AddImpiegato implements Command  {
	
	private ComplexRequest<ImpiegatoTO> request;
	private GestioneImpiegati gestioneImpiegati;
	
	public AddImpiegato(Request request){
		this.gestioneImpiegati = new GestioneImpiegati();
		this.request = (ComplexRequest<ImpiegatoTO>) request;
	}
	
	@Override
	public Response execute() {

		boolean inserito = gestioneImpiegati.addNewImpiegato(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(inserito);
		return response;
	}

}