package main.ids.util.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

import main.ids.util.exceptions.QueriesJsonFileException;

public class QueriesJsonParser extends JsonParser{
	
	private static QueriesJsonParser INSTANCE = new QueriesJsonParser();
	private static final String PATH = "resources/conf/queries.json";
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
		JsonArray queries = json.getAsJsonArray("QUERIES");
    	for(JsonElement j : queries){
    		
    		JsonObject currentJsonObj = (JsonObject)j;
    		if(currentJsonObj.get("id").toString().trim().replace("\"","").equals(id)){
    			return currentJsonObj.get(lang).toString().trim().replace("\"","");
    		}
    	}return null;
	}

}
