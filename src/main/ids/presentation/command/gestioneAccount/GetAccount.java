package main.ids.presentation.command.gestioneAccount;

import main.ids.business.applicationServices.GestioneAccount;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.AccountTO;

/**Incapsula l'azione di estrapolazione di un elemento di tipo {@link AccountTO}
 * 
 * @author bi
 *
 */
public class GetAccount implements Command  {
	

	private ComplexRequest<String> request;
	private GestioneAccount gestioneAccount;
	
	/**Inizializza il relativo application service
	 * 
	 * @param request contiene i parametri di ricerca del contratto
	 */
	public GetAccount(Request request){
		this.gestioneAccount = new GestioneAccount();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		AccountTO account = gestioneAccount.getAccount(request.getParameters().get(0));
		ComplexResponse<AccountTO> response = new ComplexResponse<AccountTO>();
		response.addParameter(account);
		return response;
	}

}
