package main.ids.util.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Delegata alla lettura di file properties
 * 
 * @author chris
 */
public abstract class PropertiesReader {
	
	protected Properties properties = new Properties();
	
	protected PropertiesReader(){
		
	}
	
	/**
	 * Inizializza l'attributo properties per un futuro reperimento
	 * 
	 * @param path Path del file properties
	 */
	protected void setProperties(String path){
		
		InputStream input = null;
		try{
			input = new FileInputStream(path);
			properties.load(input);
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/**
	 * Preleva il valora della proprietà cercata
	 * 
	 * @param key Proprietà cercata
	 * @return Relativo valore
	 */
	public String getProperty(String key){
		String property = null;
		try{
			property = properties.getProperty(key).trim();
		}catch(Exception e){
			e.printStackTrace();
		}
		return property;
	}
	
	

}
