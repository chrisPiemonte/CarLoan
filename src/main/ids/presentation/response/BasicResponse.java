package main.ids.presentation.response;
/**
 * implementa {@link Response}. Utilizzare per 
 * risposte basilari che non necessitano di 
 * dati di ritorno, ma comprendono solo un 
 * boolean per verificare la risposta
 * @author bi
 *
 */

public class BasicResponse implements Response{
	
	boolean response;
	
	public BasicResponse(){
		this.response = false;
	}

	public boolean isResponse() {
		return response;
	}

	public void setResponse(boolean response) {
		this.response = response;
	}
	

}
