package main.ids.transferObjects;

import java.time.LocalDate;

/**
 * Transfer object per il business object {@link ImpiegatoBO}
 * 
 * @author chris
 */
public class AdminTO extends ManagerTO {

	public AdminTO(){
		super();
	}
	
	public AdminTO(String cf, String nome, String cognome, LocalDate dataNascita, String telefono, String agenzia, String username){
		super(cf, nome, cognome, dataNascita, telefono, agenzia, username);
	}
	
}
