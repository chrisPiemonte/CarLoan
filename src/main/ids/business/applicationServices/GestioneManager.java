package main.ids.business.applicationServices;

import java.util.List;

import main.ids.business.businessObjects.ManagerBO;
import main.ids.transferObjects.ManagerTO;

/**
 * Application Service delegato alla gestione dei manager
 * 
 * @author chris
 */
public class GestioneManager {
	
	private ManagerBO managerBO;
	
	/**
	 * Costruttore che inizializza il relativo business object
	 */
	public GestioneManager(){
		this.managerBO = new ManagerBO();
	}

	/**
	 * Inserisce un nuovo manager
	 * 
	 * @param manager Nuovo manager da inserire
	 * @return Esito dell'operazione
	 */
	public boolean addNewManager(ManagerTO manager){
		return this.managerBO.add(manager);
	}
	
	/**
	 * Resituisce un manager
	 * 
	 * @param cf Codice fiscale del manager da cercare
	 * @return {@link ManagerTO} con i relativi dati se esiste, null altrimenti 
	 */
	public ManagerTO getManager(String cf){
		return (ManagerTO) this.managerBO.get(cf);
	}
	
	/**
	 * Restituisce tutti i manager presenti nel sistema
	 * 
	 * @return Lista contenente i manager
	 */
	public List<ManagerTO> getAll(){
		return this.managerBO.getAll();
	}
	
	/**
	 * Aggiorna i dati di un manager
	 * 
	 * @param impiegato {@link ManagerTO} con i dati aggiornati
	 * @return Esito dell'operazione
	 */
	public boolean update(ManagerTO manager){
		return this.managerBO.update(manager);
	}
	
	/**
	 * Rimuove un manager dal sistema
	 * 
	 * @param cf Codice fiscale del manager da rimuovere
	 * @return Esito dell'operazione
	 */
	public boolean delete(String cf){
		return this.managerBO.delete(cf);
	}
	
	/**
	 * Controlla se un manager esiste 
	 * 
	 * @param cf Codice fiscale del manager da controllare
	 * @return True se esiste, false altrimenti
	 */
	public boolean exists(String cf){
		return this.managerBO.exists(cf);
	}
	
	/**
	 * Resituisce l'agenzia di appartenenza del manager
	 * 
	 * @param cf Codice fiscale  del manager di cui si vuole conoscere l'agenzia
	 * @return Agenzia di appartenenza se il manager esiste, null altrimenti
	 */
	public String getAgenziaOf(String cf){
		return this.managerBO.getAgenzia(cf);
	}
	
	/**
	 * Cambia l'agenzia di appartenenza di un manager 
	 * 
	 * @param cf Codice fiscale del manager di cui si vuole cambiare l'agenzia
	 * @param newAgenzia Nuova agenzia di appartenenza
	 * @return Esito dell'operazione
	 */
	public boolean changeAgenziaOf(String cf, String newAgenzia){
		return this.managerBO.changeAgenzia(cf, newAgenzia);
	}
	
}
