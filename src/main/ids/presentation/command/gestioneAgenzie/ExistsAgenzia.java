package main.ids.presentation.command.gestioneAgenzie;

import main.ids.business.applicationServices.GestioneAgenzie;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;

/**Incapsula l'operazione di ricerca di un elemento e verifica esistenza
 * 
 * @author bi
 *
 */
public class ExistsAgenzia implements Command  {

	private ComplexRequest<String> request;
	private GestioneAgenzie gestioneAgenzie;
	
	/**Inizializza il relativo application service
	 * 
	 * @param request contiene i parametri di ricerca
	 */
	public ExistsAgenzia(Request request){
		this.gestioneAgenzie = new GestioneAgenzie();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		boolean esiste = gestioneAgenzie.exists(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(esiste);
		return response;
	}

}