package main.ids.integration.exceptions;

/**
 * Exception lanciata se si vuole prelevare una query non esistente
 * 
 * @author chris
 */
public class QueryNotFoundException extends RuntimeException{
	
	public QueryNotFoundException(String msg){
		super(msg);
	}
	
	public QueryNotFoundException(){
		
	}
	
	
}
