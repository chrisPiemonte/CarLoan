package main.ids.integration.dao.entity;

import main.ids.transferObjects.ManagerTO;

/**
 * Interfaccia che esporta le operazioni relative alla persistenza
 * 
 * @author chris
 */
public interface ManagerDAO  extends EntityDAO<ManagerTO>{
	
	/**
	 * Resituisce l'agenzia di appartenenza del manager
	 * 
	 * @param cf Codice fiscale del manager di cui si vuole conoscere l'agenzia
	 * @return Agenzia di appartenenza se il manager esiste, null altrimenti
	 */
	public String readAgenzia(String cf);
	
	/**
	 * Cambia l'agenzia di appartenenza di un manager 
	 * 
	 * @param cf Codice fiscale del manager di cui si vuole cambiare l'agenzia
	 * @param newAgenzia Nuova agenzia di appartenenza
	 * @return Esito dell'operazione
	 */
	public boolean updateAgenzia(String cf, String newAgenzia);
}
