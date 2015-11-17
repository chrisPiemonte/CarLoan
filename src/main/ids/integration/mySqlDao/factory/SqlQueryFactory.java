package main.ids.integration.mySqlDao.factory;

import main.ids.integration.dao.factory.QueryFactory;

/**
 * Factory per la restituzione di query SQL
 * 
 * @author chris
 */
public class SqlQueryFactory extends QueryFactory{
	
	/**
	 * Unica instanza delle classe
	 */
	private static final SqlQueryFactory INSTANCE = new SqlQueryFactory();
	
	private SqlQueryFactory(){
		
	}
	
	/**
	 * Restituisce l'unica istanza
	 * 
	 * @return
	 */
	public static SqlQueryFactory getInstance() {
        return INSTANCE;
    }
	
	@Override
	public String getQuery(String id){
		String query = this.queries.getQuery(id, queries.SQL);
		return query;
	}
	
}
