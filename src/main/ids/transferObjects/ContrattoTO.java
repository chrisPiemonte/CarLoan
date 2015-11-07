package main.ids.transferObjects;

import java.time.LocalDate;

public class ContrattoTO implements TransferObject  {


	//attributi
	
	private String id;
	private String cliente;
	private String auto;
	private String modNoleggio;
	private String kmNoleggio;
	private double prezzoKm;
	private LocalDate dataInizio;
	private LocalDate dataFine;
	private String agenziaInizio;
	private String agenziaFine;
	private String impInizio;
	private String impFine;
	private double acconto;
	private double kmPercorsi;
	private double tariffaBase;
	private String statoContratto;
	private double totale;
	
	//costruttore
	
	public ContrattoTO(String cliente, String auto, String modNoleggio, String kmNoleggio, double prezzoKm,
			LocalDate dataInizio, LocalDate dataFine, String agenziaInizio, String agenziaFine, String impInizio,
			String impFine, double acconto, double kmPercorsi, double tariffaBase, String statoContratto, double totale) {
		this.id = id;
		this.cliente = cliente;
		this.auto = auto;
		this.modNoleggio = modNoleggio;
		this.kmNoleggio = kmNoleggio;
		this.prezzoKm = prezzoKm;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.agenziaInizio = agenziaInizio;
		this.agenziaFine = agenziaFine;
		this.impInizio = impInizio;
		this.impFine = impFine;
		this.acconto = acconto;
		this.kmPercorsi = kmPercorsi;
		this.tariffaBase = tariffaBase;
		this.statoContratto = statoContratto;
		this.totale = totale;
	}
	
	public ContrattoTO(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getAuto() {
		return auto;
	}

	public void setAuto(String auto) {
		this.auto = auto;
	}

	public String getModNoleggio() {
		return modNoleggio;
	}

	public void setModNoleggio(String modNoleggio) {
		this.modNoleggio = modNoleggio;
	}

	public String getKmNoleggio() {
		return kmNoleggio;
	}

	public void setKmNoleggio(String kmNoleggio) {
		this.kmNoleggio = kmNoleggio;
	}

	public double getPrezzoKm() {
		return prezzoKm;
	}

	public void setPrezzoKm(double prezzoKm) {
		this.prezzoKm = prezzoKm;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}

	public String getAgenziaInizio() {
		return agenziaInizio;
	}

	public void setAgenziaInizio(String agenziaInizio) {
		this.agenziaInizio = agenziaInizio;
	}

	public String getAgenziaFine() {
		return agenziaFine;
	}

	public void setAgenziaFine(String agenziaFine) {
		this.agenziaFine = agenziaFine;
	}

	public String getImpInizio() {
		return impInizio;
	}

	public void setImpInizio(String impInizio) {
		this.impInizio = impInizio;
	}

	public String getImpFine() {
		return impFine;
	}

	public void setImpFine(String impFine) {
		this.impFine = impFine;
	}

	public double getAcconto() {
		return acconto;
	}

	public void setAcconto(double acconto) {
		this.acconto = acconto;
	}

	public double getKmPercorsi() {
		return kmPercorsi;
	}

	public void setKmPercorsi(double kmPercorsi) {
		this.kmPercorsi = kmPercorsi;
	}

	public double getTariffaBase() {
		return tariffaBase;
	}

	public void setTariffaBase(double tariffaBase) {
		this.tariffaBase = tariffaBase;
	}

	public String getStatoContratto() {
		return statoContratto;
	}

	public void setStatoContratto(String statoContratto) {
		this.statoContratto = statoContratto;
	}

	public double getTotale() {
		return totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}
	
	public String toString(){
		return this.id + " " + this.cliente + " " + this.auto + " " + this.modNoleggio + " " + 
				this.kmNoleggio + " " + this.prezzoKm + " " + this.dataInizio + " " + 
				this.dataFine + " " + this.agenziaInizio + " " + this.agenziaFine + " " +
				this.impInizio + " " + this.impFine + " " + this.acconto + " " + 
				this.kmPercorsi + " " + this.tariffaBase + " " + this.statoContratto + " " + 
				this.totale;
	}
	
}
