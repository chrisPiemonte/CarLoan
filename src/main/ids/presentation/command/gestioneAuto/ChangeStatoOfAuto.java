package main.ids.presentation.command.gestioneAuto;

import main.ids.business.applicationServices.GestioneAuto;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;

public class ChangeStatoOfAuto implements Command  {
	

	private ComplexRequest<String> request;
	private GestioneAuto gestioneAuto;
	
	
	public ChangeStatoOfAuto(Request request){
		this.gestioneAuto = new GestioneAuto();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		boolean aggiornato = gestioneAuto.changeStatoOf(request.getParameters().get(0), request.getParameters().get(1) );
		BasicResponse response = new BasicResponse();
		response.setResponse(aggiornato);
		return response;
	}

}