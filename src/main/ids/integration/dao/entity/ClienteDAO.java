package main.ids.integration.dao.entity;

import java.util.List;

import main.ids.transferObjects.ClienteTO;

/**
 * Interfaccia che esporta le operazioni relative alla persistenza
 * 
 * @author chris
 */
public interface ClienteDAO extends EntityDAO<ClienteTO>{
	
	/**
	 * Resituisce i clienti con un determinato cognome
	 * 
	 * @param cognome Cognome da cercare
	 * @return Lista di clienti con un determinato cognome
	 */
	public List<ClienteTO> readCognome(String cognome);
	
}
