package main.ids.integration.dao.factory;

import main.ids.integration.exceptions.QueryNotFoundException;
import main.ids.util.json.QueriesJsonParser;

/**
 * Factory per la restituzione delle query
 * 
 * @author chris
 */
public abstract class QueryFactory {
	
	protected QueriesJsonParser queries = QueriesJsonParser.getInstance();
	
	/**
	 * Restituisce la query specifica per il DBMS
	 * 
	 * @param id Id della query cercata
	 * @return Query
	 * @throws QueryNotFoundException Se l'id non è presente
	 */
	public abstract String getQuery(String id) throws QueryNotFoundException;
	
	
}
