package main.ids.presentation.command.gestioneAgenzie;

import main.ids.business.applicationServices.GestioneAgenzie;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.AgenziaTO;
/**Incapsula l'operazione di ricerca di un elemento 
 * 
 * @author bi
 *
 */
public class GetAgenzia implements Command  {
	

	private ComplexRequest<String> request;
	private GestioneAgenzie gestioneAgenzie;
	
	/**Inizializza il relativo application service
	 * 
	 * @param request contiene i parametri di ricerca
	 */
	public GetAgenzia(Request request){
		this.gestioneAgenzie = new GestioneAgenzie();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		AgenziaTO agenzia = gestioneAgenzie.getAgenzia(request.getParameters().get(0));
		ComplexResponse<AgenziaTO> response = new ComplexResponse<AgenziaTO>();
		response.addParameter(agenzia);
		return response;
	}

}
