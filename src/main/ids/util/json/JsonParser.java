package main.ids.util.json;

import java.io.BufferedReader;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Classe astratta per la lettura di file Json
 * 
 * @author chris
 */
public abstract class JsonParser {
	
	JsonObject json = new JsonObject();
	
	/**
	 * Inizializza l'attributo json leggendo da file
	 * 
	 * @param path Path del file Json
	 */
	protected void setJsonFile(String path){
		Gson gson = new Gson();
		try{
			BufferedReader br = new BufferedReader(new FileReader(path));  
			this.json = gson.fromJson(br, JsonObject.class);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Normalizza la stringa rimuovendo spazi e virgolette
	 * 
	 * @param string Stringa da normalizzare
	 * @return Stringa normalizzata
	 */
	public String normalize(String string){
		return string.trim().replace("\"", "");
	}
	
}
