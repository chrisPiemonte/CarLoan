package main.ids.presentation.command.gestioneAgenzie;

import main.ids.business.applicationServices.GestioneAgenzie;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.AgenziaTO;

public class UpdateAgenzia implements Command  {
	
	private ComplexRequest<AgenziaTO> request;
	private GestioneAgenzie gestioneAgenzie;
	
	
	public UpdateAgenzia(Request request){
		this.gestioneAgenzie = new GestioneAgenzie();
		this.request = (ComplexRequest<AgenziaTO>) request;
	}
	
	@Override
	public Response execute() {

		boolean aggiornato = gestioneAgenzie.update(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(aggiornato);
		return response;
	}

}
