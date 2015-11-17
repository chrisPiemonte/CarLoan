package main.ids.presentation.command.gestioneFasce;

import main.ids.business.applicationServices.GestioneFasce;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.FasciaTO;
	/**Incapsula l'operazione di aggiornamento di un elemento 
	 * 
	 * @author bi
	 *
	 */
public class UpdateFascia implements Command  {
	
	private ComplexRequest<FasciaTO> request;
	private GestioneFasce gestioneFasce;
		/**Inizializza il relativo application service
		 * 
		 * @param request contiene i parametri connessi con l'operazione 
		 */
	public UpdateFascia(Request request){
		this.gestioneFasce = new GestioneFasce();
		this.request = (ComplexRequest<FasciaTO>) request;
	}
	
	@Override
	public Response execute() {

		boolean aggiornato = gestioneFasce.update(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(aggiornato);
		return response;
	}

}