package main.ids.transferObjects;

/**
 * Transfer object per il business object {@link FasciaBO}
 * 
 * @author chris
 */
public class FasciaTO implements TransferObject {
	
	private String id ;
	private String descrizione;
	private double tariffaGiornaliera;
	private double tariffaSettimanale;
	private double tariffaKm;
	
	public FasciaTO(String id, String descrizione, double tariffaGiornaliera, double tariffaSettimanale, double tariffaKm){
		this.id = id;
		this.descrizione = descrizione;
		this.tariffaGiornaliera = tariffaGiornaliera;
		this.tariffaSettimanale = tariffaSettimanale;
		this.tariffaKm = tariffaKm;
	}
	
	public FasciaTO(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getTariffaGiornaliera() {
		return tariffaGiornaliera;
	}

	public void setTariffaGiornaliera(double tariffaGiornaliera) {
		this.tariffaGiornaliera = tariffaGiornaliera;
	}

	public double getTariffaSettimanale() {
		return tariffaSettimanale;
	}

	public void setTariffaSettimanale(double tariffaSettimanale) {
		this.tariffaSettimanale = tariffaSettimanale;
	}

	public double getTariffaKm() {
		return tariffaKm;
	}

	public void setTariffaKm(double tariffaKm) {
		this.tariffaKm = tariffaKm;
	}
	
	public String toString(){
		return this.id + " " + this.descrizione + " " + " " + this.tariffaGiornaliera + " " + 
				this.tariffaSettimanale + " " + this.tariffaKm;
	}
	
}
