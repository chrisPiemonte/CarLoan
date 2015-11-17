package main.ids.presentation.command.gestioneClienti;

import java.util.List;

import main.ids.business.applicationServices.GestioneClienti;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.ClienteTO;
	/**	Incapsula l'operazione di estrazione di elementi cliente, filtrati in base al cognome
	 * 
	 * @author bi
	 *
	 */
public class GetClienteByCognome implements Command  {
	
	private ComplexRequest<String> request;
	private GestioneClienti gestioneClienti;
	
		/**Inizializza il relativo application service
		 * 
		 * @param request contiene i parametri relativi all'operazione di ricerca
		 */
	public GetClienteByCognome(Request request){
		this.gestioneClienti = new GestioneClienti();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		List<ClienteTO> listClienti = gestioneClienti.getByCognome(request.getParameters().get(0));
		ComplexResponse<ClienteTO> response = new ComplexResponse<ClienteTO>();
		response.setParameters(listClienti);
		return response;
	}

}