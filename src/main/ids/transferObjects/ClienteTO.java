package main.ids.transferObjects;

import java.time.LocalDate;

public class ClienteTO implements TransferObject {
	
	// attributi
	private String cf;
	private String nome;
	private String cognome; 
	private LocalDate dataNascita;
	private String telefono;
	
	public ClienteTO(String cf, String nome, String cognome, LocalDate dataNascita, String telefono){
		this.cf = cf;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.telefono = telefono;
	}
	
	public ClienteTO(){
		
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
	
	public String toString(){
		return this.cf + " " + this.nome + " " + this.cognome + " " + 
				this.dataNascita.toString() + " " + this.telefono;
	}
	

}
