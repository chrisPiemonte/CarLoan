package main.ids.integration.dao.entity;

import java.util.List;

import main.ids.transferObjects.ImpiegatoTO;

/**
 * Interfaccia che esporta le operazioni relative alla persistenza
 * 
 * @author chris
 */
public interface ImpiegatoDAO extends EntityDAO<ImpiegatoTO> {
	
	/**
	 * Resituisce l'agenzia di appartenenza dell'impiegato
	 * 
	 * @param cf Codice fiscale dell'impiegato di cui si vuole conoscere l'agenzia
	 * @return Agenzia di appartenenza se l'impiegato esiste, null altrimenti
	 */
	public String readAgenzia(String cf);
	
	/**
	 * Restituisce gli impiegati con un determinato cognome 
	 * 
	 * @param cognome Cognome con cui ricercare gli impiegati
	 * @return Lista contenente gli impiegati con un determinato cognome
	 */
	public List<ImpiegatoTO> readCognome(String cognome);
	
	/**
	 * Cambia l'agenzia di appartenenza di un impiegato 
	 * 
	 * @param cf Codice fiscale dell'impiegato di cui si vuole cambiare l'agenzia
	 * @param newAgenzia Nuova agenzia di appartenenza
	 * @return Esito dell'operazione
	 */
	public boolean updateAgenzia(String cf, String newAgenzia);
	
}
