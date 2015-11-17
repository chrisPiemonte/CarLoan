package main.ids.util.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

import main.ids.util.exceptions.QueriesJsonFileException;

/**
 * Delegata alla lettura del file queries.json
 * 
 * @author chris
 */
public class QueriesJsonParser extends JsonParser{
	
	private static QueriesJsonParser INSTANCE = new QueriesJsonParser();
	private static final String PATH = "resources/conf/db/queries.json";
	public final String QUERIES_ARRAY = "QUERIES";
	public final String ID = "id";
	public final String SQL = "sql";
	
	/**
	 * Inizializza l'attributo json leggendo da file
	 */
	protected QueriesJsonParser(){
		setJsonFile(PATH);
		if(json.isJsonNull()){
			throw new QueriesJsonFileException("File: 'queries.json' not found in resources/conf folder");
		}
	}
	
	/**
	 * Restituisce l'unica istanza di tipo QueriesJsonParser
	 * 
	 * @return
	 */
	public static QueriesJsonParser getInstance(){
		return INSTANCE;
	}
	
	/**
	 * Restituisce una determinata query per un determinato linguaggio
	 * 
	 * @param id Query cercata
	 * @param lang Linguaggio specifico
	 * @return Query nel linguaggio specifico
	 */
	public String getQuery(String id, String lang){
		JsonArray queries = json.getAsJsonArray(QUERIES_ARRAY);
    	for(JsonElement j : queries){
    		
    		JsonObject currentJsonObj = (JsonObject)j;
    		String currentId = currentJsonObj.get(ID).toString();
    		if(normalize(currentId).equals(id)){
    			String currentLang = currentJsonObj.get(lang).toString();
    			return normalize(currentLang);
    		}
    	}return null;
	}

}
