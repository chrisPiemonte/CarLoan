package main.ids.presentation.command.gestioneClienti;

import main.ids.business.applicationServices.GestioneClienti;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.ClienteTO;
	/**Incapsula l'operazione di estrazione di un elemento 
	 * 
	 * @author bi
	 *
	 */
public class GetCliente implements Command  {
	
	private ComplexRequest<String> request;
	private GestioneClienti gestioneClienti;
	
		/**Inizializza il relativo application service
		 * 
		 * @param request contiene parametri relativi all'estrazione
		 */
	public GetCliente(Request request){
		this.gestioneClienti = new GestioneClienti();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		ClienteTO cliente = gestioneClienti.getCliente(request.getParameters().get(0));
		ComplexResponse<ClienteTO> response = new ComplexResponse<ClienteTO>();
		response.addParameter(cliente);
		return response;
	}

}