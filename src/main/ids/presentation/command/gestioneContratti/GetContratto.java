package main.ids.presentation.command.gestioneContratti;

import main.ids.business.applicationServices.GestioneContratti;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.ContrattoTO;
	/**Incapsula l'operazione di estrazione di un contratto 
	 * 
	 * @author bi
	 *
	 */
public class GetContratto implements Command  {
	
	private ComplexRequest<String> request;
	private GestioneContratti gestioneContratti;
		/**Inizializza il relativo application service
		 * 
		 * @param request contiene i parametri connessi con l'operazione
		 */
	public GetContratto(Request request){
		this.gestioneContratti = new GestioneContratti();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		ContrattoTO contratto = gestioneContratti.getContratto(request.getParameters().get(0));
		ComplexResponse<ContrattoTO> response = new ComplexResponse<ContrattoTO>();
		response.addParameter(contratto);
		return response;
	}

}