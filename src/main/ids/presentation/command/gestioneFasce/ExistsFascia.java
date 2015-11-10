package main.ids.presentation.command.gestioneFasce;

import main.ids.business.applicationServices.GestioneFasce;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;

public class ExistsFascia implements Command  {
	
	private ComplexRequest<String> request;
	private GestioneFasce gestioneFasce;
	
	public ExistsFascia(Request request){
		this.gestioneFasce = new GestioneFasce();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		boolean esiste = gestioneFasce.exists(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(esiste);
		return response;
	}

}