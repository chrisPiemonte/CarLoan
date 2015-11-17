package main.ids.presentation.command.gestioneAccount;

import main.ids.business.applicationServices.GestioneAccount;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;

/**Incapsula l'operazione di estrazione di una password
 * 
 * @author bi
 *
 */
public class GetPasswordOf implements Command  {
	

	private ComplexRequest<String> request;
	private GestioneAccount gestioneAccount;
	
	/**Inizializza il relativo application service
	 * 
	 * @param request contiene oltre al nome di richiesta il parametro di ricerca
	 */
	public GetPasswordOf(Request request){
		this.gestioneAccount = new GestioneAccount();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		String password = gestioneAccount.getPasswordOf(request.getParameters().get(0));
		ComplexResponse<String> response = new ComplexResponse<String>();
		response.addParameter(password);
		return response;
	}

}