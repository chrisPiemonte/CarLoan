package main.ids.business.applicationServices;

import java.util.List;

import main.ids.business.businessObjects.FasciaBO;
import main.ids.transferObjects.FasciaTO;

/**
 * Application Service delegato alla gestione delle fasce
 * 
 * @author chris
 */
public class GestioneFasce {
	
	private FasciaBO fasciaBO;
	
	/**
	 * Costruttore che inizializza il relativo business object
	 */
	public GestioneFasce(){
		this.fasciaBO = new FasciaBO();
	}
	
	/**
	 * Inserisce una nuova fascia nel sistema
	 * 
	 * @param fascia {@link FasciaTO} da inserire 
	 * @return Esito dell'operazione
	 */
	public boolean addNewFascia(FasciaTO fascia){
		return this.fasciaBO.add(fascia);
	}
	
	/**
	 * Restituisce una fascia
	 * 
	 * @param id Id della fascia da cercare
	 * @return {@link FasciaTO} con i relativi dati se presente, null altrimenti
	 */
	public FasciaTO getFascia(String id){
		return this.fasciaBO.get(id);
	}
	
	/**
	 * Restituisce tutte le fasce presenti nel sistema
	 * 
	 * @return Lista contenente le fasce presenti
	 */
	public List<FasciaTO> getAll(){
		return this.fasciaBO.getAll();
	}
	
	/**
	 * Aggiorna i dati di una fascia
	 * 
	 * @param fascia Fascia con i dati aggiornati
	 * @return Esito dell'operazione
	 */
	public boolean update(FasciaTO fascia){
		return this.fasciaBO.update(fascia);
	}
	
	/**
	 * Rimuove un fascia dal sistema
	 * 
	 * @param id Id della fascia da rimuovere
	 * @return Esito dell'operazione
	 */
	public boolean delete(String id){
		return this.fasciaBO.delete(id);
	}
	
	/**
	 * Controlla se una fascia esiste
	 * 
	 * @param id Id della fascia da controllare
	 * @return True se esiste, false altrimenti
	 */
	public boolean exists(String id){
		return this.fasciaBO.exists(id);
	}
	
	
}
