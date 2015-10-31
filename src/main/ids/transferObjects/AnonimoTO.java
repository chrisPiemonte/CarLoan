
package main.ids.transferObjects;

public class AnonimoTO implements TransferObject {
	
	//attributi 
	
	public String username;
	public String password ;
	public String tipo; 
	public String agenziaID ; 
	
	//Costruttore 
	
	public AnonimoTO(String username, String password, String tipo){
		this.username = username; 
		this.username = password; 
		this.tipo = tipo;
	}
	
	public void setAgenziaID (String agenzia){
		this.agenziaID = agenzia; 
	}

}
