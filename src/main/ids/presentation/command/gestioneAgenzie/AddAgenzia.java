package main.ids.presentation.command.gestioneAgenzie;

import main.ids.business.applicationServices.GestioneAgenzie;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.AgenziaTO;
/**Incapsula l'operazione di inserimento di un azienda
 * 
 * @author bi
 *
 */
public class AddAgenzia implements Command  {
	

	private ComplexRequest<AgenziaTO> request;
	private GestioneAgenzie gestioneAgenzie;
	
	/**Inizializza il relativo application service
	 * 
	 * @param request contiene i parametri d'inserimento 
	 */
	public AddAgenzia(Request request){
		this.gestioneAgenzie = new GestioneAgenzie();
		this.request = (ComplexRequest<AgenziaTO>) request;
	}
	
	@Override
	public Response execute() {

		boolean inserito = gestioneAgenzie.addNewAgenzia(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(inserito);
		return response;
	}

}
