package main.ids.business.applicationServices;

import java.util.List;

import main.ids.business.businessObjects.AccountBO;
import main.ids.transferObjects.AccountTO;
import main.ids.transferObjects.ImpiegatoTO;

/**
 * Application Service delegato alla gestione delle agenzie
 * 
 * @author chris
 */
public class GestioneAccount {
	
	private AccountBO accountBO;
	
	/**
	 * Costruttore che inizializza il relativo business object
	 */
	public GestioneAccount(){
		this.accountBO = new AccountBO();
	}
	
	/**
	 * Controlla se le credenziali inserite sono valide
	 * 
	 * @param username Username dell'utente
	 * @param password Password dell'utente
	 * @return oggetto contenente i dati dell'utente, o null se credenziali errate
	 */
	public ImpiegatoTO login(String username, String password){
		return this.accountBO.login(username, password);
	}
	
	/**
	 * Inserisce un nuovo account nel sistema
	 * 
	 * @param account Contiene i dati dell'account
	 * @return Esito ell'operazione
	 */
	public boolean addNewAccount(AccountTO account){
		return this.accountBO.add(account);
	}
	
	/**
	 * Restituisce un account
	 * 
	 * @param id Id dell'account da restituire
	 * @return {@link AccountTO} con i relativi dati se esiste, null altrimenti
	 */
	public AccountTO getAccount(String id){
		return this.accountBO.get(id);
	}
	
	/**
	 * Restituisce la password di un account
	 * 
	 * @param username Username di cui si vuole conoscere la password
	 * @return La password cercata se esiste l'account, null altrimenti
	 */
	public String getPasswordOf(String username){
		return this.accountBO.getPassword(username);
	}
	
	/**
	 * Restituisce tutti gli account presenti nel sistema
	 * 
	 * @return Lista contente gli account presenti
	 */
	public List<AccountTO> getAll(){
		return this.accountBO.getAll();
	}
	
	/**
	 * Aggiorna i dati di un accunt
	 * 
	 * @param account Account con i datti aggiornati
	 * @return Esito dell'operazione
	 */
	public boolean update(AccountTO account){
		return this.accountBO.update(account);
	}
	
	/**
	 * Rimuove un account dal sistema
	 * 
	 * @param id Id dell'account da rimuovere
	 * @return Esito dell'operazione
	 */
	public boolean delete(String id){
		return this.accountBO.delete(id);
	}
	
	/**
	 * Controlla se un account esiste
	 * 
	 * @param id Id dell account da cercare
	 * @return True se esiste, falso altrimenti
	 */
	public boolean exists(String id){
		return this.accountBO.exists(id);
	}
	
}
