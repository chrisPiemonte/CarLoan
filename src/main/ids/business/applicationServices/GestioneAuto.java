package main.ids.business.applicationServices;

import java.util.List;

import main.ids.business.businessObjects.AutoBO;
import main.ids.transferObjects.AutoTO;

/**
 * Application Service delegato alla gestione delle auto
 * 
 * @author chris
 */
public class GestioneAuto {
	
	private AutoBO autoBO;
	
	/**
	 * Costruttore che inizializza il relativo business object
	 */
	public GestioneAuto(){
		this.autoBO = new AutoBO();
	}
	
	/**
	 * Inserisce una nuova auto nel sistema
	 * 
	 * @param auto Auto da inserire
	 * @return Esito dell'operazione
	 */
	public boolean addNewAuto(AutoTO auto){
		return this.autoBO.add(auto);
	}
	
	/**
	 * Restituisce un auto
	 * 
	 * @param targa Targa dell'auto da cercare
	 * @return {@link AutoTO} con i relativi dati se esiste, null altrimenti
	 */
	public AutoTO getAuto(String targa){
		return this.autoBO.get(targa);
	}
	
	/**
	 * Restituisce tutte le auto presenti
	 * 
	 * @return Lista contenente le auto
	 */
	public List<AutoTO> getAll(){
		return this.autoBO.getAll();
	}
	
	/**
	 * Aggiorna i dati di un auto
	 * 
	 * @param auto Auto con i dati aggiornati
	 * @return Esito dell'operazione
	 */
	public boolean update(AutoTO auto){
		return this.autoBO.update(auto);
	}
	
	/**
	 * Rimuove un auto dal sistema
	 * 
	 * @param targa Targa dell'auto da rimuovere
	 * @return Esito dell'operazione
	 */
	public boolean delete(String targa){
		return this.autoBO.delete(targa);
	}
	
	/**
	 * Controlla se un auto esiste
	 * 
	 * @param targa Targa dell'auto da controllare
	 * @return True se esiste, false altrimenti
	 */
	public boolean exists(String targa){
		return this.autoBO.exists(targa);
	}
	
	/**
	 * Restituisce le auto presenti in una agenzia
	 * 
	 * @param agenzia Agenzia di cui si vogliono sapere le auto
	 * @return Lista di auto presenti in quella agenzia
	 */
	public List<AutoTO> getByAgenzia(String agenzia){
		return this.autoBO.getAgenzia(agenzia);
	}
	
	/**
	 * Restituisce le auto appartenenti ad un determinata fascia
	 * 
	 * @param fascia Fascia di cui si vogliono conoscere le auto
	 * @return Lista di auto appartenenti alla fascia
	 */
	public List<AutoTO> getByFascia(String fascia){
		return this.autoBO.getFascia(fascia);
	}
	
	/**
	 * Restituisce le auto con un determinato stato
	 * 
	 * @param stato Stato delle auto da restituire
	 * @return Lista di auto con un determinato stato
	 */
	public List<AutoTO> getByStato(String stato){
		return this.autoBO.getStato(stato);
	}
	
	/**
	 * Cambia lo stato di un auto
	 * 
	 * @param targa Targa dell'auto di cui si vuole cambiare stato
	 * @param newStato Nuovo stato dell'auto
	 * @return Esito dell'operazione
	 */
	public boolean changeStatoOf(String targa, String newStato){
		return this.autoBO.changeStato(targa, newStato);
	}
	
	/**
	 * Cambia i km dell'auto
	 * 
	 * @param targa Targa dell'auto di cui si vogliono aggiornare i km
	 * @param newKm Nuovi km dell'auto
	 * @return Esito dell'operazione
	 */
	public boolean changeKmOf(String targa, double newKm){
		return this.autoBO.changeKm(targa, newKm);
	}
	
	/**
	 * Controlla se un auto è disponibile
	 * 
	 * @param targa Targa dell'auto da controllare
	 * @return True se è disponibile, false altrimenti
	 */
	public boolean isAvailable(String targa){
		return this.autoBO.isAvailable(targa);
	}
	
}
