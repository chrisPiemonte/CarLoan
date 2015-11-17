package main.ids.integration.dao.entity;

import java.util.List;

import main.ids.transferObjects.AutoTO;

/**
 * Interfaccia che esporta le operazioni relative alla persistenza
 * 
 * @author chris
 */
public interface AutoDAO extends EntityDAO<AutoTO>{
	
	/**
	 * Restituisce le auto presenti in una agenzia
	 * 
	 * @param agenzia Agenzia di cui si vogliono sapere le auto
	 * @return Lista di auto presenti in quella agenzia
	 */
	public List<AutoTO> readAgenzia(String agenzia);
	
	/**
	 * Restituisce le auto appartenenti ad un determinata fascia
	 * 
	 * @param fascia Fascia di cui si vogliono conoscere le auto
	 * @return Lista di auto appartenenti alla fascia
	 */
	public List<AutoTO> readFascia(String fascia);
	
	/**
	 * 
	 * @param stato
	 * @return
	 */
	public List<AutoTO> readStato(String stato);
	
	/**
	 * Cambia lo stato di un auto
	 * 
	 * @param targa Targa dell'auto di cui si vuole cambiare stato
	 * @param newStato Nuovo stato dell'auto
	 * @return Esito dell'operazione
	 */
	public boolean updateStato(String targa, String newStato);
	
	/**
	 * Cambia i km dell'auto
	 *  
	 * @param targa Targa dell'auto di cui si vogliono aggiornare i km
	 * @param newKm Nuovi km dell'auto
	 * @return Esito dell'operazione
	 */
	public boolean updateKm(String targa, double newKm);
	
	/**
	 * Controlla se un auto è disponibile
	 * 
	 * @param targa Targa dell'auto da controllare
	 * @return True se è disponibile, false altrimenti
	 */
	boolean isDisponibile(String targa);
	
}
