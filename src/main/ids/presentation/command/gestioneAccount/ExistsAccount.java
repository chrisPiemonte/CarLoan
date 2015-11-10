package main.ids.presentation.command.gestioneAccount;

import main.ids.business.applicationServices.GestioneAccount;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;

public class ExistsAccount implements Command  {

	private ComplexRequest<String> request;
	private GestioneAccount gestioneAccount;
	
	
	public ExistsAccount(Request request){
		this.gestioneAccount = new GestioneAccount();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		boolean esiste = gestioneAccount.exists(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(esiste);
		return response;
	}

}
