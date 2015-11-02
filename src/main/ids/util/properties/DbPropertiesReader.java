package main.ids.util.properties;

import main.ids.util.exceptions.DBPropertiesFileException;

public class DbPropertiesReader extends PropertiesReader{
	
	private static DbPropertiesReader INSTANCE = new DbPropertiesReader();
	private static final String PATH = "resources/conf/mySql.properties";
	
	protected DbPropertiesReader(){
		setProperties(PATH);
		if(properties.isEmpty()){
			throw new DBPropertiesFileException("File: 'mySql.properties' not found in resources/conf folder");
		}
	}
	
	public static DbPropertiesReader getInstance(){
		return INSTANCE;
	}
	
}
