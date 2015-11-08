package main.ids.transferObjects;

import java.time.LocalDate;

public class ManagerTO extends ImpiegatoTO{
	
	public ManagerTO(){
		super();
	}
	
	public ManagerTO(String cf, String nome, String cognome, LocalDate dataNascita, String telefono, String agenzia, String username){
		super(cf, nome, cognome, dataNascita, telefono, agenzia, username);
	}
	
}
