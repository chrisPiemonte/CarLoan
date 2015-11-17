package main.ids.business.applicationServices;

import java.util.List;

import main.ids.business.businessObjects.AgenziaBO;
import main.ids.transferObjects.AgenziaTO;
import main.ids.transferObjects.ImpiegatoTO;
import main.ids.transferObjects.ManagerTO;

/**
 * Application Service delegato alla gestione delle agenzie
 * 
 * @author chris
 */
public class GestioneAgenzie {
	
	private AgenziaBO agenziaBO;
	
	/**
	 * Costruttore che inizializza il relativo business object
	 */
	public GestioneAgenzie(){
		this.agenziaBO = new AgenziaBO();
	}
	
	/**
	 * Inserisce una nuova agenzia nel sistema
	 * 
	 * @param agenzia Agenzia da inserire
	 * @return Esito dell'operazione
	 */
	public boolean addNewAgenzia(AgenziaTO agenzia){
		return this.agenziaBO.add(agenzia);
	}
	
	/**
	 * Restituisce una agenzia
	 * 
	 * @param id Id dell agenzia da cercare
	 * @return {@link AgenziaTO} con i relativi datise esiste, null altrimenti
	 */
	public AgenziaTO getAgenzia(String id){
		return this.agenziaBO.get(id);
	}
	
	/**
	 * Restituisce tutte le agenzie presenti nel sistema
	 * 
	 * @return Lista con le agenzie presenti
	 */
	public List<AgenziaTO> getAll(){
		return this.agenziaBO.getAll();
	}
	
	/**
	 * Restituisce il manager dell'agenzia
	 * 
	 * @param id Id dell agenzia di cui cercare il manager
	 * @return {@link ManagerTO} con i relativi dati, null altrimenti
	 */
	public ManagerTO getManagerOf(String id){
		return this.agenziaBO.getManager(id);
	}
	
	/**
	 * Restituisce gli impiegati di un agenzia
	 * 
	 * @param id Id dell agnezia di cui cercare gli impiegati
	 * @return Lista contenente gli impiegati
	 */
	public List<ImpiegatoTO> getImpiegatiOf(String id){
		return this.agenziaBO.getImpiegati(id);
	}
	
	/**
	 * Aggiorna i dati di un agenzia
	 * 
	 * @param agenzia Agenzia con i dati aggiornati
	 * @return Esito dell'operazione
	 */
	public boolean update(AgenziaTO agenzia){
		return this.agenziaBO.update(agenzia);
	}
	
	/**
	 * Rimuove un agenzia dal sistema
	 * 
	 * @param id Id dell'agenzia da rimuovere
	 * @return Esito dell'operazione
	 */
	public boolean delete(String id){
		return this.agenziaBO.delete(id);
	}
	
	/**
	 * Rimuove tutte le agenzie in una città
	 * 
	 * @param id Città di cui si vogliono rimuovere le agenzie
	 * @return Esito dell'operazione
	 */
	public boolean deleteCitta(String id){
		return this.agenziaBO.deleteCitta(id);
	}
	
	/**
	 * Controlla se un agenzia esiste
	 * 
	 * @param id Id dell'agenzia da controllare
	 * @return True se esiste, false altrimenti
	 */
	public boolean exists(String id){
		return this.agenziaBO.exists(id);
	}
	
}
