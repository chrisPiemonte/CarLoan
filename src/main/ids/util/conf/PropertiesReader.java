package main.ids.util.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public abstract class PropertiesReader {
	
	protected Properties properties = new Properties();
	
	
	protected PropertiesReader(){
		
	}
	
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
	
	public String getProperty(String key){
		return properties.getProperty(key).trim();
	}
	
	

}
