package main.ids.transferObjects;

public class ImpiegatoTO {
	
	public String id; 
	public String nome;
	public String cognome; 
	public String agenziaId;
	
	public ImpiegatoTO(String id, String nome, String cognome, String agenziaId){
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.agenziaId = agenziaId;
	}
	
	public ImpiegatoTO(String id, String nome, String cognome){
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		
	}
	
	public String getAgenziaId(){
		return agenziaId ;
	}
	
	public void setAgenziaId(String agenzia){
		this.agenziaId = agenzia;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getCognome(){
		return nome;
	}
	
	public String getId(){
		return id;
	}
	
}
