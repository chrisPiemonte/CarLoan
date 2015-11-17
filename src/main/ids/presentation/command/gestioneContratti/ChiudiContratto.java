package main.ids.presentation.command.gestioneContratti;

import main.ids.business.applicationServices.GestioneContratti;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;
	/**Incapsula l'operazione di chiusura di contratto
	 * 
	 * @author bi
	 *
	 */
public class ChiudiContratto implements Command  {
	
	private ComplexRequest<Object> request;
	private GestioneContratti gestioneContratti;
		/**Inizializza il relativo application service
		 * 
		 * @param request contiene i parametri connessi con l'operazione di chiusura
		 */
	public ChiudiContratto(Request request){
		this.gestioneContratti = new GestioneContratti();
		this.request = (ComplexRequest<Object>) request;
	}
	
	@Override
	public Response execute() {
		boolean chiuso = gestioneContratti.chiudiContratto((String)request.getParameters().get(0), 
				(String)request.getParameters().get(1), (double)request.getParameters().get(2), 
				(double)request.getParameters().get(3));
		BasicResponse response = new BasicResponse();
		response.setResponse(chiuso);
		return response;
	}

}