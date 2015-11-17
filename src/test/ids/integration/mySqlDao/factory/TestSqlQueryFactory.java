package test.ids.integration.mySqlDao.factory;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.ids.integration.mySqlDao.factory.SqlQueryFactory;

public class TestSqlQueryFactory {
	
	SqlQueryFactory queryFactory;
	
	@Before
	public void setUp() throws Exception {
		queryFactory = SqlQueryFactory.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		queryFactory = null;
	}

	@Test
	public void tesGetQuery() {
		String[] id = {"create_agenzia", "test"};
		String[] expected = {
				"INSERT INTO `carloan`.`agenzia` (`citta`, `indirizzo`, `telefono`, `stato`) VALUES (?, ?, ?, ?);", 
				null
				};
		
		for(int i = 0; i < expected.length; i++){
			assertEquals("Failed at " + i, queryFactory.getQuery(id[i]), expected[i]);
		}
		
	}

}
