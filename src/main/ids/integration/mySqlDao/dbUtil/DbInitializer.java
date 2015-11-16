package main.ids.integration.mySqlDao.dbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import main.ids.integration.mySqlDao.factory.MySqlConnectionFactory;

public class DbInitializer {

	private static final String DB_SCHEMA_PATH = "resources/conf/db/db_schema.sql";
	private static final String DB_POPULATE_PATH = "resources/conf/db/db_populate.sql";
	private static final String DB = "carloan";
	
	public static boolean isPresent(String db){
		boolean found = false;
		Connection connection = null;
		ResultSet resultSet = null;
		try{
			
		connection = MySqlConnectionFactory.getConnection();
		resultSet = connection.getMetaData().getCatalogs();

		//iterate each catalog in the ResultSet
		while (resultSet.next()) {
		  // Get the database name, which is at position 1
		  if(resultSet.getString(1).equals(db)){
			  found = true;
		  }
		}
		resultSet.close();
		
		}catch(Exception e){
			
		}finally{
			DbEntityCloser.close(resultSet);
			DbEntityCloser.close(connection);
		}
		
		return found;
	}
	
	public static boolean init(){
		boolean done = false;
		Connection connection = null;
		PreparedStatement prepStatement = null;
		if(!isPresent(DB)){
			
			try{
				List<String> schemaStatements = SqlScriptReader.toStatementList(DB_SCHEMA_PATH);
				List<String> populateStatements = SqlScriptReader.toStatementList(DB_POPULATE_PATH);
				
				connection = MySqlConnectionFactory.getConnection();
				
				for(String statement : schemaStatements){
					prepStatement = null;
					prepStatement = connection.prepareStatement(statement);
					prepStatement.executeUpdate();
				}
				
				for(String statement : populateStatements){
					prepStatement = null;
					prepStatement = connection.prepareStatement(statement);
					prepStatement.executeUpdate();
				}
				done = true;
				
			}catch(Exception e){
				e.printStackTrace();
				done = false;
			}finally{
				DbEntityCloser.close(prepStatement);
				DbEntityCloser.close(connection);
			}
		
		}else {
			done = true;
		}
		
		return done;
	}
}
