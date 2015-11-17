package main.ids.business.applicationServices;

import java.time.LocalDate;
import java.util.List;

import main.ids.business.businessObjects.ContrattoBO;
import main.ids.transferObjects.ContrattoTO;

/**
 * Application Service delegato alla gestione dei contratti
 * 
 * @author chris
 */
public class GestioneContratti {
	
	private ContrattoBO contrattoBO;
	
	/**
	 * Costruttore che inizializza il relativo business object
	 */
	public GestioneContratti(){
		this.contrattoBO = new ContrattoBO();
	}
	
	/**
	 * Apre un contratto per il noleggio dell'auto
	 * 
	 * @param contratto {@link ContrattoTO} contenente i dati necessari all'apertura
	 * @return Esito dell'operazione
	 */
	public boolean apriContratto(ContrattoTO contratto){
		return this.contrattoBO.add(contratto);
	}
	
	/**
	 * Restituisce un contratto
	 * 
	 * @param id Id del contratto da cercare
	 * @return {@link ContrattoTO} con i relativi dati se presente, null altrimenti
	 */
	public ContrattoTO getContratto(String id){
		return this.contrattoBO.get(id);
	}
	
	/**
	 * Restituisce i tutti i contratti stipulati
	 * 
	 * @return Lista contenente i contratti
	 */
	public List<ContrattoTO> getAll(){
		return this.contrattoBO.getAll();
	}
	
	/**
	 * Aggiorna i dati di un contratto
	 * 
	 * @param contratto Contratto con i dati aggiornati
	 * @return Esito dell'operazione
	 */
	public boolean update(ContrattoTO contratto){
		return this.contrattoBO.update(contratto);
	}
	
	/**
	 * Rimuove un contratto dal sistema. Usato solo per la fase di test
	 * 
	 * @param id Id del contratto da rimuovere
	 * @return Esito dell'operazione
	 */
	public boolean delete(String id){
		return this.contrattoBO.delete(id);
	}
	
	/**
	 * Controlla se un contratto esiste
	 * 
	 * @param id Id del contratto da controllare
	 * @return True se esiste, false altrimenti
	 */
	public boolean exists(String id){
		return this.contrattoBO.exists(id);
	}
	
	/**
	 * Cambia la modalità di noleggio inserita precedentemente
	 * 
	 * @param id Id del contratto di cui si vuole cambiare la modalità
	 * @param newModNoleggio Nuova modalità di noleggio
	 * @return Esito dell'operazione
	 */
	public boolean changeModNoleggio(String id, String newModNoleggio){
		return this.contrattoBO.changeModNoleggio(id, newModNoleggio);
	}
	
	/**
	 * Cambia la data di restituzione inserita precedentemente
	 * 
	 * @param id Id del contratto di cui si vuole cambiare la data di restituzione
	 * @param newDataFine Nuova data di restituzione
	 * @return Esito dell'operazione
	 */
	public boolean changeDataFine(String id, LocalDate newDataFine){
		return this.contrattoBO.changeDataFine(id, newDataFine);
	}
	
	/**
	 * Cambia la ageznia di restituzione inserita precedentemente
	 * 
	 * @param id Id del contratto di cui si vuole cambiare l'agenzia di restituzione
	 * @param newAgenziaFine Nuova agenzia di restituzione
	 * @return Esito dell'operazione
	 */
	public boolean changeAgenziaFine(String id, String newAgenziaFine){
		return this.contrattoBO.changeAgenziaFine(id, newAgenziaFine);
	}
	
	/**
	 * Chiude un contratto aperto
	 * 
	 * @param id Id del contratto da chiudere
	 * @param impFine Impiegato che chiude il contratto
	 * @param kmPercorsi Km percorsi dall'auto noleggiata
	 * @param totale Prezzo totale del noleggio
	 * @return Esito dell'operazione
	 */
	public boolean chiudiContratto(String id, String impFine, double kmPercorsi, double totale){
		return this.contrattoBO.chiudiContratto(id, impFine, kmPercorsi, totale);
	}
	
	
}
