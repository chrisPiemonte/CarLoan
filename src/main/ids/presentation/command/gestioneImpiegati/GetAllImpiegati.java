package main.ids.presentation.command.gestioneImpiegati;

import java.util.List;

import main.ids.business.applicationServices.GestioneImpiegati;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.ImpiegatoTO;
	/**Incapsula l'operazione di estrazione di tutti gli elementi
	 * 
	 * @author bi
	 *
	 */
public class GetAllImpiegati implements Command  {
		
	private Request request;
	private GestioneImpiegati gestioneImpiegati;
		/**Inizializza il relativo application service
		 * 
		 * @param request non contiene i parametri connessi con l'operazione
		 */
	public GetAllImpiegati(Request request){
		this.gestioneImpiegati = new GestioneImpiegati();
		this.request = request;
	}
	
	@Override
	public Response execute() {

		List<ImpiegatoTO> listImpiegati = gestioneImpiegati.getAll();
		ComplexResponse<ImpiegatoTO> response = new ComplexResponse<ImpiegatoTO>();
		response.setParameters(listImpiegati);
		return response;
	}

}