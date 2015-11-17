package main.ids.business.applicationServices;

import java.util.List;

import main.ids.business.businessObjects.ClienteBO;
import main.ids.transferObjects.ClienteTO;

/**
 * Application Service delegato alla gestione dei clienti
 * 
 * @author chris
 */
public class GestioneClienti {
	
	private ClienteBO clienteBO;
	
	/**
	 * Costruttore che inizializza il relativo business object
	 */
	public GestioneClienti(){
		this.clienteBO = new ClienteBO();
	}
	
	/**
	 * Inserisce un nuovo cliente nel sistema
	 * 
	 * @param cliente Cliente da inserire
	 * @return Esito dell'operazione
	 */
	public boolean addNewCliente(ClienteTO cliente){
		return this.clienteBO.add(cliente);
	}
	
	/**
	 * Restituisce un cliente
	 * 
	 * @param cf Codice fiscale del cliente da cercare
	 * @return {@link ClienteTO} con i relativi dat se esiste, null altrimenti
	 */
	public ClienteTO getCliente(String cf){
		return this.clienteBO.get(cf);
	}
	
	/**
	 * Restituisce tutti i clienti presenti
	 * 
	 * @return Liste contenente i clienti presenti
	 */
	public List<ClienteTO> getAll(){
		return this.clienteBO.getAll();
	}
	
	/**
	 * Aggiorna i dati di un cliente
	 * 
	 * @param cliente Cliente da aggiornare
	 * @return Esito dell'operazione
	 */
	public boolean update(ClienteTO cliente){
		return this.clienteBO.update(cliente);
	}
	
	/**
	 * Rimuove un cliente dal sistema 
	 * 
	 * @param cf Codice fiscale del cliente da rimuovere
	 * @return Esito del'operazione
	 */
	public boolean delete(String cf){
		return this.clienteBO.delete(cf);
	}
	
	/**
	 * Controlla se un cliente esiste
	 * 
	 * @param cf Codice fiscale del cliente da controllare
	 * @return True se esiste, false altrimenti
	 */
	public boolean exists(String cf){
		return this.clienteBO.exists(cf);
	}
	
	/**
	 * Resituisce i clienti con un determinato cognome
	 * 
	 * @param cognome Cognome da cercare
	 * @return Lista di clienti con un determinato cognome
	 */
	public List<ClienteTO> getByCognome(String cognome){
		return this.clienteBO.getByCognome(cognome);
	}
	
	
}
