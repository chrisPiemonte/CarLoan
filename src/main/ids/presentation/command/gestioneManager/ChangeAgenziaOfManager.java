package main.ids.presentation.command.gestioneManager;

import main.ids.business.applicationServices.GestioneManager;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;
	/**Incapsula l'operazione di modifica di agenzia all interno di manager
	 * 
	 * @author bi
	 *
	 */
public class ChangeAgenziaOfManager implements Command  {
	
	private ComplexRequest<String> request;
	private GestioneManager gestionemanager;
		/**contiene i parametri corrispondenti all'agenzia
		 * 
		 * @param request contiene i parametri del manager da modificare
		 */
	public ChangeAgenziaOfManager(Request request){
		this.gestionemanager = new GestioneManager();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		boolean aggiornato = gestionemanager.changeAgenziaOf(request.getParameters().get(0), 
				request.getParameters().get(1));
		BasicResponse response = new BasicResponse();
		response.setResponse(aggiornato);
		return response;
	}

}