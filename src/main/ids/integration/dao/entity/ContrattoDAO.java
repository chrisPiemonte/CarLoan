package main.ids.integration.dao.entity;

import java.time.LocalDate;

import main.ids.transferObjects.ContrattoTO;

/**
 * Interfaccia che esporta le operazioni relative alla persistenza
 * 
 * @author chris
 */
public interface ContrattoDAO extends EntityDAO<ContrattoTO> {
	
	/**
	 * Cambia la modalità di noleggio inserita precedentemente
	 * 
	 * @param id Id del contratto di cui si vuole cambiare la modalità
	 * @param newModNoleggio Nuova modalità di noleggio
	 * @return Esito dell'operazione
	 */
	public boolean updateModNoleggio(String id, String newModNoleggio);
	
	/**
	 * Cambia la data di restituzione inserita precedentemente
	 * 
	 * @param id Id del contratto di cui si vuole cambiare la data di restituzione
	 * @param newDataFine Nuova data di restituzione
	 * @return Esito dell'operazione
	 */
	public boolean updateDataFine(String id, LocalDate newDataFine);
	
	/**
	 * Cambia la ageznia di restituzione inserita precedentemente
	 * 
	 * @param id Id del contratto di cui si vuole cambiare l'agenzia di restituzione
	 * @param newAgenziaFine Nuova agenzia di restituzione
	 * @return Esito dell'operazione
	 */
	public boolean updateAgenziaFine(String id, String newAgenziaFine);
	
	/**
	 * Chiude un contratto aperto
	 * 
	 * @param id Id del contratto da chiudere
	 * @param impFine Impiegato che chiude il contratto
	 * @param kmPercorsi Km percorsi dall'auto noleggiata
	 * @param totale Prezzo totale del noleggio
	 * @return Esito dell'operazione
	 */
	public boolean updateChiudiContratto(String id, String impFine, double kmPercorsi, double totale);
	
}
