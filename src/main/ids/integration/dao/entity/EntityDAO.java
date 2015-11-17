package main.ids.integration.dao.entity;

import java.util.List;

/**
 * Interfaccia che esporta le operazioni CRUD relative alla persistenza
 * 
 * @author chris
 */
public interface EntityDAO<T> {
	
	/**
	 * Operazione create
	 * 
	 * @param elem Elemento da creare
	 * @return Esito dell'operazione
	 */
	public boolean create(T elem);
	
	/**
	 * Operazione read
	 * 
	 * @param id Id del elemento da leggere
	 * @return
	 */
	public T read(String id);
	
	/**
	 * Operazione read all
	 * 
	 * @return Lista di elementi
	 */
	public List<T> readAll();
	
	/**
	 * Operazione update
	 * 
	 * @param elem Elemento da aggiornare
	 * @return Esito dell'operazione
	 */
	public boolean update(T elem);
	
	/**
	 * Operazione delete
	 * 
	 * @param id Id dell'elemnto da rimuovere
	 * @return Esito dell'operazione
	 */
	public boolean delete(String id);
	
	/**
	 * Operazione is present
	 * 
	 * @param id Id dell'elementoda controllare
	 * @return True se esiste, false altrimenti
	 */
	public boolean isPresent(String id);
	
}
