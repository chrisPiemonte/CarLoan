package main.ids.integration.mySqlDao.entity;

import main.ids.integration.mySqlDao.factory.SqlQueryFactory;

public class MySqlEntityDAO {
	
	protected SqlQueryFactory queryFactory;
	
	public MySqlEntityDAO() {
		queryFactory = SqlQueryFactory.getInstance();
	}
	
}
