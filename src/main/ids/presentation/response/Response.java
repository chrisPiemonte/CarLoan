package main.ids.presentation.response;

import main.ids.presentation.FrontController;

/**
 * Utilizzate dal {@link FrontController} come risposta in 
 * output ad i comandi
 * @author bi
 *
 */
public interface Response {

	public boolean isResponse();

	public void setResponse(boolean response);
	
	

}
