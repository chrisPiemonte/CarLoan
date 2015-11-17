package main.ids.integration.dao.entity;

import java.util.List;

import main.ids.transferObjects.AgenziaTO;
import main.ids.transferObjects.ImpiegatoTO;
import main.ids.transferObjects.ManagerTO;

/**
 * Interfaccia che esporta le operazioni relative alla persistenza
 * 
 * @author chris
 */
public interface AgenziaDAO extends EntityDAO<AgenziaTO>{
	
	/**
	 * Restituisce il manager dell'agenzia
	 * 
	 * @param id Id dell agenzia di cui cercare il manager
	 * @return {@link ManagerTO} con i relativi dati, null altrimenti
	 */
	ManagerTO readManager(String id);
	
	/**
	 * Restituisce gli impiegati di un agenzia
	 * 
	 * @param id Id dell agnezia di cui cercare gli impiegati
	 * @return Lista contenente gli impiegati
	 */
	List<ImpiegatoTO> readImpiegati(String id);
	
	/**
	 * Rimuove tutte le agenzie in una città
	 * 
	 * @param citta Città di cui si vogliono rimuovere le agenzie
	 * @return Esito dell'operazione
	 */
	boolean deleteCitta(String citta);
	
}
