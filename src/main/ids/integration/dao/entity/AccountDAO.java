package main.ids.integration.dao.entity;

import main.ids.transferObjects.AccountTO;
import main.ids.transferObjects.ImpiegatoTO;

/**
 * Interfaccia che esporta le operazioni relative alla persistenza
 * 
 * @author chris
 */
public interface AccountDAO  extends EntityDAO<AccountTO>{
	
	/**
	 * Verifica le credenziali inserite
	 * 
	 * @param username Username dell'utente
	 * @param password Password dell'utente
	 * @return oggetto contenente i dati dell'utente, o null se credenziali errate
	 */
	public ImpiegatoTO login(String username, String password);
	
	/**
	 * Restituisce la password di un account
	 * 
	 * @param username Username di cui si vuole conoscere la password
	 * @return La password cercata se esiste l'account, null altrimenti
	 */
	public String readPassword(String username);
	
}
