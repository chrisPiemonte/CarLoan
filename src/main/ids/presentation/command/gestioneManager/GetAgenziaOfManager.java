package main.ids.presentation.command.gestioneManager;

import main.ids.business.applicationServices.GestioneManager;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
	/**Incapsula l'estrazione di un attributo agenzia, filtrata in base ad un manager
	 * 
	 * @author bi
	 *
	 */
public class GetAgenziaOfManager implements Command  {
	
	private ComplexRequest<String> request;
	private GestioneManager gestioneManager;
		/**Inizializza il relativo application service
		 * 
		 * @param request contiene i parametri del manager
		 */
	public GetAgenziaOfManager(Request request){
		this.gestioneManager = new GestioneManager();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		String agenziaId = gestioneManager.getAgenziaOf(request.getParameters().get(0));
		ComplexResponse<String> response = new ComplexResponse<String>();
		response.addParameter(agenziaId);
		return response;
	}

}