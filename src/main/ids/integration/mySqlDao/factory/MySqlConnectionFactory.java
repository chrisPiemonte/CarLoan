package main.ids.integration.mySqlDao.factory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import main.ids.util.properties.DbPropertiesReader;
import main.ids.util.properties.PropertiesReader;

public class MySqlConnectionFactory {
	
	private static MySqlConnectionFactory INSTANCE = new MySqlConnectionFactory();
	private String src;
	private String db;
	private String user;
	private String password;
	
	protected MySqlConnectionFactory(){
		setConnectionConf();
	}
	
	private void setConnectionConf(){
		PropertiesReader dbProp = DbPropertiesReader.getInstance();
		this.db       = dbProp.getProperty("db");
		this.src      = dbProp.getProperty("src");
		this.user     = dbProp.getProperty("user");
		this.password = dbProp.getProperty("password");
		
	}
	
	public Connection createConnection(){
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(src + db, user, password);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Connection getConnection(){
		return INSTANCE.createConnection();
	}
	
	
	
	// mysql -u root -p
	public static void main(String[] args) {
		
		Gson gson = new Gson();
		JsonObject jo = new JsonObject();
		try{
			BufferedReader br = new BufferedReader(new FileReader("resources/conf/queries.json"));  
			jo = gson.fromJson(br, JsonObject.class);
			System.out.println(jo.toString());
			String s = jo.get("QUERIES").toString();
			System.out.println(s + "###########");
			JsonArray ja = jo.getAsJsonArray("SQL");
			for(JsonElement j : ja){
				
			}
		}catch(Exception e){
			
		}

		Connection connection = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		
		
		connection = getConnection();
		
		//-------------------------------------
		
		ResultSet resultSet = connection.getMetaData().getCatalogs();

		//iterate each catalog in the ResultSet
		while (resultSet.next()) {
		  // Get the database name, which is at position 1
		  String databaseName = resultSet.getString(1);
		  if(databaseName.equals("ciao")) System.out.println("\t found");
		  System.out.println(databaseName);
		}
		resultSet.close();
		
		//-------------------------------------
		
		}catch(Exception e){
			
		}
		
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		
	}
	
	

}
