package main.ids.presentation.command.gestioneAuto;

import java.util.List;

import main.ids.business.applicationServices.GestioneAuto;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.AutoTO;
	/**Incapsula l'operazione di estrazione di elementi auto, filtrati in base all'agenzia
	 * 
	 * @author bi
	 *
	 */
public class GetAutoByAgenzia implements Command {
	

	private ComplexRequest<String> request;
	private GestioneAuto gestioneAuto;
		/**Inizializza il relativo application service
		 * 
		 * @param request contiene i parametri corrispondenti all'agenzia
		 */
	public GetAutoByAgenzia(Request request){
		this.gestioneAuto = new GestioneAuto();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		List<AutoTO> listAuto = gestioneAuto.getByAgenzia(request.getParameters().get(0));
		ComplexResponse<AutoTO> response = new ComplexResponse<AutoTO>();
		response.setParameters(listAuto);
		return response;
	}

}