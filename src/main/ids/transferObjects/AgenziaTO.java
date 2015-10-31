package main.ids.transferObjects;

public class AgenziaTO implements TransferObject {
	
	//attributi 
	
	public String id ;
	public String città;
	public String indirizzo;
	
	// costruttori
	
	public AgenziaTO(String id, String città, String indirizzo){
		this.id = id;
		this.città = città;
		this.indirizzo = indirizzo;
	}
	
	public AgenziaTO(String id){
		this.id = id;
	}
	
	//operazioni
	
	public String getId (){
		return id;
	}
	
	public String getCittà(){
		return città;
	}
	
	public String getIndirizzo(){
		return indirizzo;
	}
	
	public void setCittà(String città){
		this.città = città;
	}
	
	public void setIndirizzo(String indirizzo){
		this.indirizzo = indirizzo;
	}

}
