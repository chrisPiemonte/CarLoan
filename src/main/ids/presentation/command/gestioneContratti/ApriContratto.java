package main.ids.presentation.command.gestioneContratti;

import main.ids.business.applicationServices.GestioneContratti;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.ContrattoTO;
	/**Incapsula l'operazione di inserimento di un nuovo contratto
	 * 
	 * @author bi
	 *
	 */
public class ApriContratto implements Command  {
	
	private ComplexRequest<ContrattoTO> request;
	private GestioneContratti gestioneContratti;
		/**Inizializza il relativo application service
		 * 
		 * @param request contiene i parametri corrispondenti all'operazione
		 */
	public ApriContratto(Request request){
		this.gestioneContratti = new GestioneContratti();
		this.request = (ComplexRequest<ContrattoTO>) request;
	}
	
	@Override
	public Response execute() {

		boolean inserito = gestioneContratti.apriContratto(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(inserito);
		return response;
	}

}