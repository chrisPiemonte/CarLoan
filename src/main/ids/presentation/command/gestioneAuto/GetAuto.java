package main.ids.presentation.command.gestioneAuto;

import main.ids.business.applicationServices.GestioneAuto;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.ComplexResponse;
import main.ids.presentation.response.Response;
import main.ids.transferObjects.AutoTO;
	/**Incapsula l'operazione di estrazione di un elemento
	 * 
	 * @author bi
	 *
	 */
public class GetAuto implements Command {
	

	private ComplexRequest<String> request;
	private GestioneAuto gestioneAuto;
	
		/**Inizializza il relativo application service
		 * 
		 * @param request contiene i parametri relativi all'auto da estrarre
		 */
	public GetAuto(Request request){
		this.gestioneAuto = new GestioneAuto();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		AutoTO auto = gestioneAuto.getAuto(request.getParameters().get(0));
		ComplexResponse<AutoTO> response = new ComplexResponse<AutoTO>();
		response.addParameter(auto);
		return response;
	}

}