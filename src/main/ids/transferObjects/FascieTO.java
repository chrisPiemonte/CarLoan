package main.ids.transferObjects;

public class FascieTO {
	
	// attributi 
	
	public String id ;
	public String descrizione;
	public int prezzo;
	
	public FascieTO(String id, int prezzo){
		this.id = id;
		this.prezzo = prezzo;
	}
	
	public FascieTO(String id, String descrizione, int prezzo){
		this.id = id;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		
	}
	
	public void setDescrizione(String descrizione){
		this.descrizione = descrizione;
	}
	
	public String getId(){
		return id;
	}
	
	public int getPrezzo() {
		return prezzo;
	}
	
	public String getDescrizione(){
		return descrizione;
	}

}
