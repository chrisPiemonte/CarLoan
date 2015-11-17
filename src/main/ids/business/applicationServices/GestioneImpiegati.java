package main.ids.business.applicationServices;

import java.util.List;

import main.ids.business.businessObjects.ImpiegatoBO;
import main.ids.transferObjects.ImpiegatoTO;

/**
 * Application Service delegato alla gestione degli impiegati
 * 
 * @author chris
 */
public class GestioneImpiegati {
	
	private ImpiegatoBO impiegatoBO;
	
	/**
	 * Costruttore che inizializza il relativo business object
	 */
	public GestioneImpiegati(){
		this.impiegatoBO = new ImpiegatoBO();
	}
	
	/**
	 * Inserisce un nuovo impiegato
	 * 
	 * @param impiegato Nuovo impiegato da inserire
	 * @return Esito dell'operazione
	 */
	public boolean addNewImpiegato(ImpiegatoTO impiegato){
		return this.impiegatoBO.add(impiegato);
	}
	
	/**
	 * Resituisce un impiegato
	 * 
	 * @param cf Codice fiscale dell'impiegato da cercare
	 * @return {@link ImpiegatoTO} con i relativi dati se esiste, null altrimenti 
	 */
	public ImpiegatoTO getImpiegato(String cf){
		return this.impiegatoBO.get(cf);
	}
	
	/**
	 * Restituisce tutti gli impiegati presenti nel sistema
	 * 
	 * @return Lista contenente gli impiegati
	 */
	public List<ImpiegatoTO> getAll(){
		return this.impiegatoBO.getAll();
	}
	
	/**
	 * Aggiorna i dati di un impiegato
	 * 
	 * @param impiegato {@link ImpiegatoTO} con i dati aggiornati
	 * @return Esito dell'operazione
	 */
	public boolean update(ImpiegatoTO impiegato){
		return this.impiegatoBO.update(impiegato);
	}
	
	/**
	 * Rimuove un impiegato dal sistema
	 * 
	 * @param cf Codice fiscale dell'impiegato da rimuovere
	 * @return Esito dell'operazione
	 */
	public boolean delete(String cf){
		return this.impiegatoBO.delete(cf);
	}
	
	/**
	 * Controlla se un impiegato esiste 
	 * 
	 * @param cf Codice fiscale dell'impiegato da controllare
	 * @return True se esiste, false altrimenti
	 */
	public boolean exists(String cf){
		return this.impiegatoBO.exists(cf);
	}
	
	/**
	 * Resituisce l'agenzia di appartenenza dell'impiegato
	 * 
	 * @param cf Codice fiscale dell'impiegato di cui si vuole conoscere l'agenzia
	 * @return Agenzia di appartenenza se l'impiegato esiste, null altrimenti
	 */
	public String getAgenziaOf(String cf){
		return this.impiegatoBO.getAgenzia(cf);
	}
	
	/**
	 * Restituisce gli impiegati con un determinato cognome
	 * 
	 * @param cognome Cognome con cui ricercare gli impiegati
	 * @return Lista contenente gli impiegati con un determinato cognome
	 */
	public List<ImpiegatoTO> getByCognome(String cognome){
		return this.impiegatoBO.getCognome(cognome);
	}
	
	/**
	 * Cambia l'agenzia di appartenenza di un impiegato 
	 * 
	 * @param cf Codice fiscale dell'impiegato di cui si vuole cambiare l'agenzia
	 * @param newAgenzia Nuova agenzia di appartenenza
	 * @return Esito dell'operazione
	 */
	public boolean changeAgenziaOf(String cf, String newAgenzia){
		return this.impiegatoBO.changeAgenzia(cf, newAgenzia);
	}
	
	
}
