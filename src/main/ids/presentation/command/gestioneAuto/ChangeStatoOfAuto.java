package main.ids.presentation.command.gestioneAuto;

import main.ids.business.applicationServices.GestioneAuto;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;
	/**Incapsula l'azione di modifica di chilometraggio di un elemento auto 
	 * 
	 * @author bi
	 *
	 */
public class ChangeStatoOfAuto implements Command  {
	

	private ComplexRequest<String> request;
	private GestioneAuto gestioneAuto;
	
		/**Inizializza il relativo application service
		 * 
		 * @param request contiene i parametri relativi all auto sul quale applicare l'azione 
		 */
	public ChangeStatoOfAuto(Request request){
		this.gestioneAuto = new GestioneAuto();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		boolean aggiornato = gestioneAuto.changeStatoOf(request.getParameters().get(0), request.getParameters().get(1) );
		BasicResponse response = new BasicResponse();
		response.setResponse(aggiornato);
		return response;
	}

}