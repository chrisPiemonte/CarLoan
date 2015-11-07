package main.ids.transferObjects;

import java.time.LocalDate;

public class AutoTO implements TransferObject  {
	
	// attributi
	private String targa;
	private String modello;
	private String stato;
	private String fascia;
	private double km;
	private LocalDate manutenzioneOrdinaria;
	private String agenzia;
	
	// costruttori
	public AutoTO (String targa, String modello, String stato, String fascia, double km, LocalDate manutenzioneOrdinaria, String agenzia){
		this.targa = targa;
		this.modello = modello;
		this.stato = stato;
		this.fascia = fascia;
		this.km = km;
		this.manutenzioneOrdinaria = manutenzioneOrdinaria;
		this.agenzia = agenzia;
	}
	
	public AutoTO (){
		
	}
	
	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getFascia() {
		return fascia;
	}

	public void setFascia(String fascia) {
		this.fascia = fascia;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public LocalDate getManutenzioneOrdinaria() {
		return manutenzioneOrdinaria;
	}

	public void setManutenzioneOrdinaria(LocalDate manutenzioneOrdinaria) {
		this.manutenzioneOrdinaria = manutenzioneOrdinaria;
	}

	public String getAgenzia() {
		return agenzia;
	}

	public void setAgenzia(String agenzia) {
		this.agenzia = agenzia;
	}
	
	public String toString(){
		return this.targa + " " + this.modello + " " + this.stato + " " + this.fascia + " " + 
				this.km + " " + this.manutenzioneOrdinaria + " " + this.agenzia;
	}

}
