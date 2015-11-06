package main.ids.transferObjects;

import java.time.LocalDate;

public class ImpiegatoTO {
	
	private String cf; 
	private String nome;
	private String cognome; 
	private LocalDate dataNascita;
	private String telefono;
	private String agenzia;
	private String username;
	
	public ImpiegatoTO(){
		
	}
	
	public ImpiegatoTO(String cf, String nome, String cognome, LocalDate dataNascita, String telefono, String agenzia, String username){
		this.cf = cf;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.telefono = telefono;
		this.agenzia = agenzia;
		this.username = username;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getAgenzia() {
		return agenzia;
	}

	public void setAgenzia(String agenzia) {
		this.agenzia = agenzia;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String toString(){
		return this.getCf() + " " + this.getNome() + " " + this.getCognome() + " " + 
				this.getDataNascita() + " " + this.getTelefono() + " " + this.getAgenzia() + " " + 
				this.getUsername();
	}
	
}
