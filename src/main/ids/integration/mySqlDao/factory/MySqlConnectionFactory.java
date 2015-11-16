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
			conn = DriverManager.getConnection(src, user, password);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Connection getConnection(){
		return INSTANCE.createConnection();
	}

}
