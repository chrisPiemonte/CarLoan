package main.ids.integration.mySqlDao.factory;

import main.ids.integration.dao.factory.QueryFactory;
import main.ids.integration.exceptions.QueryNotFoundException;

public class SqlQueryFactory extends QueryFactory{
	
	 private static final SqlQueryFactory INSTANCE = new SqlQueryFactory();
	 
	private SqlQueryFactory(){
		
	}
	
	public static SqlQueryFactory getInstance() {
        return INSTANCE;
    }

	@Override
	public String getQuery(String id){
		String query = this.queries.getQuery(id, queries.SQL);
		return query;
	}
	
}
