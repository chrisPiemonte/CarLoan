package main.ids.presentation.command.gestioneContratti;

import java.time.LocalDate;

import main.ids.business.applicationServices.GestioneContratti;
import main.ids.presentation.command.Command;
import main.ids.presentation.request.ComplexRequest;
import main.ids.presentation.request.Request;
import main.ids.presentation.response.BasicResponse;
import main.ids.presentation.response.Response;
	/**Incapsula l'operazione di aggiornamento di un attributo di contratto
	 * 
	 * @author bi
	 *
	 */
public class ChangeDataFineContratto implements Command  {
	
	private ComplexRequest<Object> request;
	private GestioneContratti gestioneContratti;
		/**Inizializza il relativo application service
		 * 
		 * @param request contiene i parametri connessi con l'operazione
		 */
	public ChangeDataFineContratto(Request request){
		this.gestioneContratti = new GestioneContratti();
		this.request = (ComplexRequest<Object>) request;
	}
	
	@Override
	public Response execute() {
		boolean aggiornato = gestioneContratti.changeDataFine((String)request.getParameters().get(0), 
				(LocalDate)request.getParameters().get(1));
		BasicResponse response = new BasicResponse();
		response.setResponse(aggiornato);
		return response;
	}

}