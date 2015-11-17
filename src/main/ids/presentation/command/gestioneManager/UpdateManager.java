package main.ids.presentation.command.gestioneManager;

import main.ids.business.applicationServices.GestioneManager;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.ManagerTO;
	/**Incapsula l'operazione di aggiornamento di un elemento 
	 * 
	 * @author bi
	 *
	 */
public class UpdateManager implements Command  {
	
	private ComplexRequest<ManagerTO> request;
	private GestioneManager gestionemanager;
		/**Inizializza il relativo application service
		 * 
		 * @param request contiene i parametri connessi con l'aggiornamento 
		 */
	public UpdateManager(Request request){
		this.gestionemanager = new GestioneManager();
		this.request = (ComplexRequest<ManagerTO>) request;
	}
	
	@Override
	public Response execute() {

		boolean aggiornato = gestionemanager.update(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(aggiornato);
		return response;
	}

}