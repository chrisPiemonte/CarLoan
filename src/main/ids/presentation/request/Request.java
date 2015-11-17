package main.ids.presentation.request;

import java.util.List;

/**Classe per la gestione delle richieste gestite tramite il 
 * {@link FrontController}
 * complende due tipologie, {@link ComplexRequest} e {@link BasicRequest}
 * 
 * @author bi
 *
 */

public interface Request {
	
	public RequestType getType() ;

	public String getRequest();

	public void setRequest(String request);
		
}
