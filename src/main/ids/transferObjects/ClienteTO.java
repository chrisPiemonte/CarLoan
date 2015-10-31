package main.ids.transferObjects;

import java.time.LocalDate;

public class ClienteTO implements TransferObject {
	
	//attributi
	
	public String nome;
	public String cognome; 
	public String sesso;
	public String CF;
	public LocalDate dataNascita;
	public String luogoNascita;
	public String estremiDocumento;
	
	ClienteTO(String nome, String cognome, String sesso, String CF, LocalDate dataNascita,String luogoNascita,String estremiDocumento){
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.CF = CF;
		this.dataNascita = dataNascita;
		this.luogoNascita = luogoNascita;
		this.estremiDocumento = estremiDocumento;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getCognome(){
		return cognome;
	}
	
	public String getCF(){
		return CF;
	}
	
	

}
