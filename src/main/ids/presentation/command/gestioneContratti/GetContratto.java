package main.ids.presentation.command.gestioneContratti;

import main.ids.business.applicationServices.GestioneContratti;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.ContrattoTO;

public class GetContratto implements Command  {
	
	private ComplexRequest<String> request;
	private GestioneContratti gestioneContratti;
	
	public GetContratto(Request request){
		this.gestioneContratti = new GestioneContratti();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		ContrattoTO contratto = gestioneContratti.getContratto(request.getParameters().get(0));
		ComplexResponse<ContrattoTO> response = new ComplexResponse<ContrattoTO>();
		response.addParameter(contratto);
		return response;
	}

}