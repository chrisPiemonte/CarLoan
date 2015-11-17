package main.ids.util.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import main.ids.util.exceptions.QueriesJsonFileException;

/**È un insieme di chiavi valori gestite tramite json 
 * contenente i percorsi delle view ed indentificate 
 * da una chiave per ogni percorso 
 * 
 * @author bi
 *
 *
 */

public class ViewsJsonParser extends JsonParser {
	
	private static ViewsJsonParser INSTANCE = new ViewsJsonParser();
	private static final String JSON_PATH = "resources/conf/view/view.json";
	public final String VIEWS_ARRAY = "VIEWS";
	public final String ID = "id";
	public final String VIEW_PATH = "path";
	
	protected ViewsJsonParser(){
		setJsonFile(JSON_PATH);
		if(json.isJsonNull()){
			throw new QueriesJsonFileException("File: 'queries.json' not found in resources/conf folder");
		}
	}
	
	public static ViewsJsonParser getInstance(){
		return INSTANCE;
	}
	
	public String getViewPath(String id){
		try{
			JsonArray views = json.getAsJsonArray(VIEWS_ARRAY);
	    	for(JsonElement j : views){
	    		JsonObject currentJsonObj = (JsonObject) j;
	    		String currentId = currentJsonObj.get(ID).toString();
	    		if(normalize(currentId).equals(id)){
	    			String currentViewPath = currentJsonObj.get(VIEW_PATH).toString();
	    			return normalize(currentViewPath);
	    		}
	    	}
		}catch(Exception e){
			e.printStackTrace();
		}
    	return null;
	}
	
	

}
