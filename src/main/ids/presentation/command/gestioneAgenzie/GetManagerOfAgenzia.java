package main.ids.presentation.command.gestioneAgenzie;

import main.ids.business.applicationServices.GestioneAgenzie;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.ManagerTO;
/**Incapsula l'operazione di estrazione del manager, da un agenzia
 * 
 * @author bi
 *
 */
public class GetManagerOfAgenzia implements Command  {

	private ComplexRequest<String> request;
	private GestioneAgenzie gestioneAgenzie;
	
	/**Inizializza il relativo application service
	 * 
	 * @param request contiene i metodi relativi all'agenzia
	 */
	public GetManagerOfAgenzia(Request request){
		this.gestioneAgenzie = new GestioneAgenzie();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		ManagerTO manager = gestioneAgenzie.getManagerOf(request.getParameters().get(0));
		ComplexResponse<ManagerTO> response = new ComplexResponse<ManagerTO>();
		response.addParameter(manager);
		return response;
	}

}
