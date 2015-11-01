package main.ids.integration.mySqlDao.factory;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import main.ids.util.conf.DbPropertiesReader;
import main.ids.util.conf.PropertiesReader;

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
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			
		}
		
		Connection connection = getConnection();

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
	
	

}
