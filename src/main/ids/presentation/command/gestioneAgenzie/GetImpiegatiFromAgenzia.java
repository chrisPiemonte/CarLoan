package main.ids.presentation.command.gestioneAgenzie;

import java.util.List;

import main.ids.business.applicationServices.GestioneAgenzie;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.ImpiegatoTO;

public class GetImpiegatiFromAgenzia implements Command  {
	
	private ComplexRequest<String> request;
	private GestioneAgenzie gestioneAgenzie;
	
	
	public GetImpiegatiFromAgenzia(Request request){
		this.gestioneAgenzie = new GestioneAgenzie();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		List<ImpiegatoTO> listImpiegati = gestioneAgenzie.getImpiegatiOf(request.getParameters().get(0));
		ComplexResponse<ImpiegatoTO> response = new ComplexResponse<ImpiegatoTO>();
		response.setParameters(listImpiegati);
		return response;
	}

}
