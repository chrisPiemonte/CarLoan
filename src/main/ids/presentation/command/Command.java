package main.ids.presentation.command;

import main.ids.presentation.response.Response;
import main.ids.presentation.request.Request;
/**Interfaccia che permette di isolare chi effettua un azione da chi ne richiede un esecuzione
 * 
 * @author bi
 *
 */

public interface Command {
	
	public Response execute();
	
	
}
