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
	public String getQuery(String id) throws QueryNotFoundException{
		String query = this.queries.getQuery(id, queries.SQL);
		if(query != null){
			return query;
		}else {
			throw new QueryNotFoundException("Query not found");
		}
	}
	
	public static void main(String[] args) {
		QueryFactory qf = SqlQueryFactory.getInstance();
		System.out.println(qf.getQuery("login"));

	}
	
}
