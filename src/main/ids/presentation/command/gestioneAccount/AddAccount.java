package main.ids.presentation.command.gestioneAccount;

import main.ids.business.applicationServices.GestioneAccount;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.AccountTO;

public class AddAccount implements Command  {
	

	private ComplexRequest<AccountTO> request;
	private GestioneAccount gestioneAccount;
	
	
	public AddAccount(Request request){
		this.gestioneAccount = new GestioneAccount();
		this.request = (ComplexRequest<AccountTO>) request;
	}
	
	@Override
	public Response execute() {

		boolean inserito = gestioneAccount.addNewAccount(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(inserito);
		return response;
	}

}
