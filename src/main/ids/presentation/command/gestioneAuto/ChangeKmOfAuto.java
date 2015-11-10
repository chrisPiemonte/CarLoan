package main.ids.presentation.command.gestioneAuto;

import main.ids.business.applicationServices.GestioneAuto;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;

public class ChangeKmOfAuto implements Command  {
	

	private ComplexRequest<Object> request;
	private GestioneAuto gestioneAuto;
	
	
	public ChangeKmOfAuto(Request request){
		this.gestioneAuto = new GestioneAuto();
		this.request = (ComplexRequest<Object>) request;
	}
	
	@Override
	public Response execute() {

		boolean aggiornato = gestioneAuto.changeKmOf((String)request.getParameters().get(0), (double)request.getParameters().get(1) );
		BasicResponse response = new BasicResponse();
		response.setResponse(aggiornato);
		return response;
	}

}