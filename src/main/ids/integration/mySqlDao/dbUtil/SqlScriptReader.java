package main.ids.integration.mySqlDao.dbUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe per la lettura di script SQL
 * 
 * @author chris
 */
public class SqlScriptReader {
	
	/**
	 * Trasforma ogni statement letto dal file in un stringa
	 * 
	 * @param path Path del file SQL da leggere
	 * @return Lista di statement
	 */
	public static List<String> toStatementList(String path){
		
		List<String> statementList = new ArrayList<String>();
		
		try{
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			
			String line = reader.readLine();
			StringBuilder statement = new StringBuilder();
			while(line != null){
				statement.append(" ").append(line);
				if(line.contains(";")){
					// System.out.println(statement.toString());
					statementList.add(statement.toString());
					statement = new StringBuilder();
				}
				line = reader.readLine();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return statementList;
	}
	
}
