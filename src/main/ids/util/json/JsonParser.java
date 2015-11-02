package main.ids.util.json;

import java.io.BufferedReader;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public abstract class JsonParser {
	
	JsonObject json = new JsonObject();
	
	protected void setJsonFile(String path){
		Gson gson = new Gson();
		try{
			BufferedReader br = new BufferedReader(new FileReader(path));  
			this.json = gson.fromJson(br, JsonObject.class);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public JsonElement getValue(String key){
		return this.json.get(key);
	}
	
}
