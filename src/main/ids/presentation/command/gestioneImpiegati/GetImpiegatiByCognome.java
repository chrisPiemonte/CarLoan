package main.ids.presentation.command.gestioneImpiegati;

import java.util.List;

import main.ids.business.applicationServices.GestioneImpiegati;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.ImpiegatoTO;
	/**Incapsula l'operazione di estrazione di elementi impiegato, filtrati in base al cognome
	 * 
	 * @author bi
	 *
	 */
public class GetImpiegatiByCognome implements Command  {
	
	private ComplexRequest<String> request;
	private GestioneImpiegati gestioneImpiegati;
		/**Inizializza il relativo application service
		 * 
		 * @param request contiene i parametri connessi con l'operazione 
		 */
	public GetImpiegatiByCognome(Request request){
		this.gestioneImpiegati = new GestioneImpiegati();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		List<ImpiegatoTO> listImpiegati = gestioneImpiegati.getByCognome(request.getParameters().get(0));
		ComplexResponse<ImpiegatoTO> response = new ComplexResponse<ImpiegatoTO>();
		response.setParameters(listImpiegati);
		return response;
	}

}