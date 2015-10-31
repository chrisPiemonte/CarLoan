package main.ids.transferObjects;

public class ManagerTO {
	
	public String id;
	public String nome;
	public String cognome;
	public String agenziaID;
	
	
	public ManagerTO(String id, String nome, String cognome){
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		
		
	}
	public ManagerTO(String id, String nome, String cognome, String agenziaID ){
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.agenziaID = agenziaID ;
		
	}
	
	public void setAgenzia(String agenziaID){
		this.agenziaID = agenziaID;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public String getId(){
		return id;
	}
	
	public String getAgenziaId(){
		return agenziaID;
	}

}
