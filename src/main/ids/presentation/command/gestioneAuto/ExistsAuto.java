package main.ids.presentation.command.gestioneAuto;

import main.ids.business.applicationServices.GestioneAuto;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;

public class ExistsAuto implements Command  {
	

	private ComplexRequest<String> request;
	private GestioneAuto gestioneAuto;
	
	
	public ExistsAuto(Request request){
		this.gestioneAuto = new GestioneAuto();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		boolean esiste = gestioneAuto.exists(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(esiste);
		return response;
	}

}