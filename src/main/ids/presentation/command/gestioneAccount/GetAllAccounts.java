package main.ids.presentation.command.gestioneAccount;

import java.util.List;

import main.ids.business.applicationServices.GestioneAccount;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.AccountTO;
/**Incapsula l'operazione di estrazione di tutti gli elementi di tipo {@link AccountTO}
 * 
 * @author bi
 *
 */
public class GetAllAccounts implements Command  {
	

	private Request request;
	private GestioneAccount gestioneAccount;
	
	/**Inizializza il relativo application service
	 * 
	 * @param request contentente solo il nome dell'operazione
	 */
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
