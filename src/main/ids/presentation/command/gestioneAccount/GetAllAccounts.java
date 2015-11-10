package main.ids.presentation.command.gestioneAccount;

import java.util.List;

import main.ids.business.applicationServices.GestioneAccount;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.AccountTO;

public class GetAllAccounts implements Command  {
	

	private Request request;
	private GestioneAccount gestioneAccount;
	
	
	public GetAllAccounts(Request request){
		this.gestioneAccount = new GestioneAccount();
		this.request = request;
	}
	
	@Override
	public Response execute() {

		List<AccountTO> listAccount = gestioneAccount.getAll();
		ComplexResponse<AccountTO> response = new ComplexResponse<AccountTO>();
		response.setParameters(listAccount);
		return response;
	}

}
