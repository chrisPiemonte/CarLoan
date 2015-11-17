package main.ids.presentation.command.gestioneAuto;

import main.ids.business.applicationServices.GestioneAuto;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;

/**
 * Incapsula l'azione di controllare la disponibilità di un auto 
 * 
 * @author chris
 */
public class IsAvailableAuto implements Command  {
	

	private ComplexRequest<String> request;
	private GestioneAuto gestioneAuto;
	
	/**
	 * Costruttore che inizializza il relativo application service
	 */
	public IsAvailableAuto(Request request){
		this.gestioneAuto = new GestioneAuto();
		this.request = (ComplexRequest<String>) request;
	}
	
	@Override
	public Response execute() {

		boolean disponibile = gestioneAuto.isAvailable(request.getParameters().get(0));
		BasicResponse response = new BasicResponse();
		response.setResponse(disponibile);
		return response;
	}

}