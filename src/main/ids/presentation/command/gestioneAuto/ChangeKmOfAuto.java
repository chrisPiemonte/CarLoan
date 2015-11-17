package main.ids.presentation.command.gestioneAuto;

import main.ids.business.applicationServices.GestioneAuto;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;
/**Incapsula l' azione di modifica di uno stato, da un auto 
 * 
 * @author bi
 *
 */
public class ChangeKmOfAuto implements Command  {
	

	private ComplexRequest<Object> request;
	private GestioneAuto gestioneAuto;
	
	/**Inizializza il relativo application service
	 * 
	 * @param request contiene i parametri relativi all'azione 
	 */
	public ChangeKmOfAuto(Request request){
		this.gestioneAuto = new GestioneAuto();
		this.request = (ComplexRequest<Object>) request;
	}
	
	@Override
	public Response execute() {

		boolean aggiornato = gestioneAuto.changeKmOf((String)request.getParameters().get(0), (double)request.getParameters().get(1) );
		BasicResponse response = new BasicResponse();
		response.setResponse(aggiornato);
		return response;
	}

}