package main.ids.presentation.command.gestioneImpiegati;

import main.ids.business.applicationServices.GestioneImpiegati;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;
	/**Incapsula l'operazione di modifica dell'attributo
	 * agenzia per un impiegato
	 * 
	 * @author bi
	 *
	 */
public class ChangeAgenziaOfImpiegato implements Command  {
	
	private ComplexRequest<String> request;
	private GestioneImpiegati gestioneImpiegati;
		/**Inizializza il relativo application service
		 * 
		 * @param request contiene i parametri connessi con la modifica
		 */
	public ChangeAgenziaOfImpiegato(Request request){
		this.gestioneImpiegati = new GestioneImpiegati();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		boolean aggiornato = gestioneImpiegati.changeAgenziaOf(request.getParameters().get(0), 
				request.getParameters().get(1));
		BasicResponse response = new BasicResponse();
		response.setResponse(aggiornato);
		return response;
	}

}