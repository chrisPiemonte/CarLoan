package main.ids.integration.mySqlDao.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.ids.integration.dao.entity.ManagerDAO;
import main.ids.integration.mySqlDao.dbUtil.DbEntityCloser;
import main.ids.integration.mySqlDao.factory.MySqlConnectionFactory;
import main.ids.transferObjects.ManagerTO;

public class MySqlManagerDAO extends MySqlEntityDAO implements ManagerDAO{
	
	public MySqlManagerDAO() {
        super();
    }

	@Override
	public boolean create(ManagerTO manager) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		
		int result = 0;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("create_impiegato"));
			int i = 1;
			statement.setString(i++, manager.getCf());
			statement.setString(i++, manager.getNome());
			statement.setString(i++, manager.getCognome());
			statement.setDate  (i++, java.sql.Date.valueOf(manager.getDataNascita()));
			statement.setString(i++, manager.getTelefono());
			statement.setString(i++, manager.getAgenzia());
			statement.setString(i++, manager.getUsername());
			statement.setString(i++, "attivo");
			
			result = statement.executeUpdate();
			
			if(result > 0) response = true;
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
				
		return response;
	}

	@Override
	public ManagerTO read(String cf) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ManagerTO manager = null;
		ResultSet resultSet = null;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_manager"));
			statement.setString(1, cf);
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				manager = new ManagerTO();
				manager.setCf(resultSet.getString("cf"));
				manager.setNome(resultSet.getString("nome"));
				manager.setCognome(resultSet.getString("cognome"));
				manager.setDataNascita(resultSet.getDate("data_nascita").toLocalDate());
				manager.setTelefono(resultSet.getString("telefono"));
				manager.setAgenzia(resultSet.getString("agenzia"));
				manager.setUsername(resultSet.getString("username"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return manager;
	}
	
	@Override
	public List<ManagerTO> readAll() {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		List<ManagerTO> listManager = new ArrayList<ManagerTO>();;
		ResultSet resultSet = null;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_all_manager"));
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				ManagerTO manager = new ManagerTO();
				manager.setCf(resultSet.getString("cf"));
				manager.setNome(resultSet.getString("nome"));
				manager.setCognome(resultSet.getString("cognome"));
				manager.setDataNascita(resultSet.getDate("data_nascita").toLocalDate());
				manager.setTelefono(resultSet.getString("telefono"));
				manager.setAgenzia(resultSet.getString("agenzia"));
				manager.setUsername(resultSet.getString("username"));
				listManager.add(manager);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return listManager;
	}
	
	@Override
	public String readAgenzia(String cf) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String agenzia = null;
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_agenzia_impiegato"));
			statement.setString(1, cf);
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				agenzia = resultSet.getString("agenzia");
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return agenzia;
	}
	
	@Override
	public boolean update(ManagerTO manager) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		int result;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("update_impiegato"));
			int i = 1;
			statement.setString(i++, manager.getCf());
			statement.setString(i++, manager.getNome());
			statement.setString(i++, manager.getCognome());
			statement.setDate  (i++, java.sql.Date.valueOf(manager.getDataNascita()));
			statement.setString(i++, manager.getTelefono());
			statement.setString(i++, manager.getAgenzia());
			statement.setString(i++, manager.getUsername());
			statement.setString(i++, manager.getCf());
			
			result = statement.executeUpdate();
			
			if(result > 0) response = true;
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return response;
	}
	
	@Override
	public boolean updateAgenzia(String cf, String newAgenzia) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		int result;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("update_agenzia_impiegato"));
			int i = 1;
			statement.setString(i++, newAgenzia);
			statement.setString(i++, cf);
			
			result = statement.executeUpdate();
			
			if(result > 0) response = true;
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return response;
	}	
	
	@Override
	public boolean delete(String cf) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		int result;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("update_stato_impiegato"));
			int i = 1;
			statement.setString(i++, cf);
			
			result = statement.executeUpdate();
			
			if(result > 0) response = true;
			
		}catch(SQLException e){
			e.printStackTrace();
			fire(cf);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return response;
	}

	private boolean fire(String cf) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		int result;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("update_stato_impiegato"));
			int i = 1;
			statement.setString(i++, cf);
			
			result = statement.executeUpdate();
			
			if(result > 0) response = true;
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return response;
	}

	@Override
	public boolean isPresent(String cf) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		boolean present = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_impiegato"));
			statement.setString(1, cf);
			
			resultSet = statement.executeQuery();
			if(resultSet.next()) present = true;
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return present;
	}
	
}
