package main.ids.util.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

import main.ids.util.exceptions.QueriesJsonFileException;

public class QueriesJsonParser extends JsonParser{
	
	private static QueriesJsonParser INSTANCE = new QueriesJsonParser();
	private static final String PATH = "resources/conf/db/queries.json";
	public final String QUERIES_ARRAY = "QUERIES";
	public final String ID = "id";
	public final String SQL = "sql";
	
	protected QueriesJsonParser(){
		setJsonFile(PATH);
		if(json.isJsonNull()){
			throw new QueriesJsonFileException("File: 'queries.json' not found in resources/conf folder");
		}
	}
	
	public static QueriesJsonParser getInstance(){
		return INSTANCE;
	}
	
	
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
