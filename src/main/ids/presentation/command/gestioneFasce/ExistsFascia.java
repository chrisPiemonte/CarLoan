package main.ids.presentation.command.gestioneFasce;

import main.ids.business.applicationServices.GestioneFasce;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;
	/**Incapsula l'operazione di ricerca e verifica di un elemento all interno del sistema
	 * 
	 * @author bi
	 *
	 */
public class ExistsFascia implements Command  {
	
	private ComplexRequest<String> request;
	private GestioneFasce gestioneFasce;
		/**Inizializza il relativo application service
		 * 
		 * @param request contiene i parametri connessi con la ricerca
		 */
	public ExistsFascia(Request request){
		this.gestioneFasce = new GestioneFasce();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		boolean esiste = gestioneFasce.exists(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(esiste);
		return response;
	}

}