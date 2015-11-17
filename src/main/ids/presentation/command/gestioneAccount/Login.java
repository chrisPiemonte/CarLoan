package main.ids.presentation.command.gestioneAccount;

import main.ids.business.applicationServices.GestioneAccount;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.ImpiegatoTO;

/**Incapsula l'operazione di verifica delle credenziali inserite
 * 
 * 
 * @author bi
 *
 */
public class Login implements Command {

	private ComplexRequest<String> request;
	private GestioneAccount gestioneAccount;
	
	/**Inizializza il relativo application service
	 * 
	 * @param request contiene le credenziali
	 */
	public Login(Request request){
		this.gestioneAccount = new GestioneAccount();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {
		
		ImpiegatoTO impiegato = gestioneAccount.login(request.getParameters().get(0), 
				request.getParameters().get(1));
		ComplexResponse<ImpiegatoTO> response = new ComplexResponse<ImpiegatoTO>();
		response.addParameter(impiegato);
		return response;
	}
	
	

}
