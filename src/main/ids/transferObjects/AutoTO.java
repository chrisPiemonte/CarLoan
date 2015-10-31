package main.ids.transferObjects;

import java.time.LocalDate;

public class AutoTO implements TransferObject  {
	
	//attributi 
	
	public String targa;
	public String modello; 
	public String fascia;
	public LocalDate dataManutenzioneStraordinaria;
	public LocalDate dataManutenzioneOrdinaria;
	public int km;
	
	//costruttori
	
	public AutoTO (String t, String m, LocalDate dateS,LocalDate dateO,int km){
		this.targa = t;
		this.modello = m;
		this.dataManutenzioneStraordinaria = dateS;
		this.dataManutenzioneOrdinaria = dateO;
		this.km = km;
	}
	
	public String getTarga(){
		return targa; 
	}
	
	public String getModello(){
		return modello; 
	}
	
	public String getFascia(){
		return fascia; 
	}
	
	public LocalDate getDataManutenzioneStraordinaria(){
		return dataManutenzioneStraordinaria;
	}
	
	public LocalDate getDataManutenzioneOrdinaria(){
		return dataManutenzioneOrdinaria;
	}
	
	public int getKm(){
		return km;
	}
	
	public void setKm(int km){
		this.km = km;
	}
	
	
	

}
