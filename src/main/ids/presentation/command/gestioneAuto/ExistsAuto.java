package main.ids.presentation.command.gestioneAuto;

import main.ids.business.applicationServices.GestioneAuto;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;
	/**Incapsula l'operazione di ricerca e validazione di presenza di un elemento
	 * 
	 * @author bi
	 *
	 */
public class ExistsAuto implements Command  {
	

	private ComplexRequest<String> request;
	private GestioneAuto gestioneAuto;
	
		/**Inizializza il relativo application service
		 * 
		 * @param request contiene i dati relativi all auto per l operazione 
		 */
	public ExistsAuto(Request request){
		this.gestioneAuto = new GestioneAuto();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		boolean esiste = gestioneAuto.exists(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(esiste);
		return response;
	}

}