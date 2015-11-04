package main.ids.util.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import main.ids.util.exceptions.QueriesJsonFileException;

public class ViewsJsonParser extends JsonParser {
	
	private static ViewsJsonParser INSTANCE = new ViewsJsonParser();
	private static final String JSON_PATH = "resources/conf/view/view.json";
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
		JsonArray views = json.getAsJsonArray("VIEWS");
    	for(JsonElement j : views){
    		
    		JsonObject currentJsonObj = (JsonObject) j;
    		if(currentJsonObj.get("id").toString().trim().replace("\"","").equals(id)){
    			return currentJsonObj.get(VIEW_PATH).toString().trim().replace("\"","");
    		}
    	}return null;
	}
	
	
	
	public static void main(String[] args) {
		ViewsJsonParser vjp = ViewsJsonParser.getInstance();
		System.out.println(vjp.getViewPath("bootstrap"));

	}

}
