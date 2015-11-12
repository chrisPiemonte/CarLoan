package main.ids.integration.mySqlDao.dbUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SqlScriptReader {
	
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
	
	public static void main(String[] args){
		
		// toStatementList(DB_POPULATE_PATH);
		// System.out.println(LocalDate.now().toString());
		
	}
	
	
	
}
