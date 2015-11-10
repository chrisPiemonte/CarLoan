package main.ids.presentation.command.gestioneAgenzie;

import main.ids.business.applicationServices.GestioneAgenzie;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.AgenziaTO;

public class GetAgenzia implements Command  {
	

	private ComplexRequest<String> request;
	private GestioneAgenzie gestioneAgenzie;
	
	
	public GetAgenzia(Request request){
		this.gestioneAgenzie = new GestioneAgenzie();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		AgenziaTO agenzia = gestioneAgenzie.getAgenzia(request.getParameters().get(0));
		ComplexResponse<AgenziaTO> response = new ComplexResponse<AgenziaTO>();
		response.addParameter(agenzia);
		return response;
	}

}
