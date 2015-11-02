package main.ids.integration.dao.factory;

import main.ids.integration.exceptions.QueryNotFoundException;
import main.ids.util.json.QueriesJsonParser;

public abstract class QueryFactory {
	
	protected QueriesJsonParser queries = QueriesJsonParser.getInstance();
	
	public abstract String getQuery(String id) throws QueryNotFoundException;
	
	
}
