package main.ids.transferObjects;

import java.time.LocalDate;

public class ContrattoTO implements TransferObject  {


	//attributi
	
	public String id;
	public LocalDate dataApertura;
	public LocalDate dataChiusura;
	public int fattura;
	public String fasciaID;
	public String autoID;
	public String operatoreID;
	public String clienteID;
	public String agenziaApertura;
	public String agenziaRitiro;
	public int kmPercorsi;
	public int acconto;
	public String modalità;
	
	//costruttore 
	
	public ContrattoTO(String id, LocalDate dataApertura, LocalDate dataChiusura, String fasciaID, String operatoreID,String autoID,String clienteID, String agenziaRitiro, String agenziaApertura,String modalità){
		this.id = id;
		this.dataApertura = dataApertura;
		this.dataChiusura = dataChiusura;
		this.fasciaID = fasciaID;
		this.operatoreID = operatoreID;
		this.autoID = autoID;
		this.clienteID = clienteID;
		this.agenziaApertura = agenziaApertura;
		this.agenziaRitiro = agenziaRitiro;
		this.modalità = modalità;
	}
	
	public void setFattura(int fattura){
		this.fattura = fattura;
	}
	
	public void setKmPercorsi(int km ) {
		this.kmPercorsi = km;
	}
	
	public void setAcconto(int acconto){
		this.acconto = acconto;
	}
	
	public String getId(){ return id; } 
	
	public String getModalità(){ return modalità; }
	
	
	
	

}
