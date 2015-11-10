package main.ids.presentation.command.gestioneAccount;

import main.ids.business.applicationServices.GestioneAccount;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.AccountTO;

public class UpdateAccount implements Command  {
	

	private ComplexRequest<AccountTO> request;
	private GestioneAccount gestioneAccount;
	
	
	public UpdateAccount(Request request){
		this.gestioneAccount = new GestioneAccount();
		this.request = (ComplexRequest<AccountTO>) request;
	}
	
	@Override
	public Response execute() {

		boolean aggiornato = gestioneAccount.update(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(aggiornato);
		return response;
	}

}
