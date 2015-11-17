package main.ids.presentation.command.gestioneContratti;

import main.ids.business.applicationServices.GestioneContratti;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.ContrattoTO;
	/**Incapsula l'operazione di aggiornamento di un elemento 
	 * 
	 * @author bi
	 *
	 */
public class UpdateContratto implements Command  {
	
	private ComplexRequest<ContrattoTO> request;
	private GestioneContratti gestioneContratti;
		/**Inizializza il relativo application service
		 * 
		 * @param request contiene i parametri connessi con l'operazione 
		 */
	public UpdateContratto(Request request){
		this.gestioneContratti = new GestioneContratti();
		this.request = (ComplexRequest<ContrattoTO>) request;
	}
	
	@Override
	public Response execute() {

		boolean aggiornato = gestioneContratti.update(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(aggiornato);
		return response;
	}

}