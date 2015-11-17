package main.ids.util.properties;

import main.ids.util.exceptions.DBPropertiesFileException;

/**
 * Delegata alla lettura del file mySql.properties
 * 
 * @author chris
 */
public class DbPropertiesReader extends PropertiesReader{
	
	private static DbPropertiesReader INSTANCE = new DbPropertiesReader();
	private static final String PATH = "resources/conf/db/mySql.properties";
	
	/**
	 * Costruttore che inizializza l'attributo properties
	 */
	protected DbPropertiesReader(){
		setProperties(PATH);
		if(properties.isEmpty()){
			throw new DBPropertiesFileException("File: 'mySql.properties' not found in resources/conf folder");
		}
	}
	
	/**
	 * Restituisce l'unica istanza di DbPropertiesReader
	 * 
	 * @return Istanza DbPropertiesReader
	 */
	public static DbPropertiesReader getInstance(){
		return INSTANCE;
	}
	
}
