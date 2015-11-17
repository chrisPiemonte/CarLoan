package main.ids.integration.mySqlDao.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.ids.integration.dao.entity.ImpiegatoDAO;
import main.ids.integration.mySqlDao.dbUtil.DbEntityCloser;
import main.ids.integration.mySqlDao.factory.MySqlConnectionFactory;
import main.ids.transferObjects.ImpiegatoTO;

public class MySqlImpiegatoDAO extends MySqlEntityDAO implements ImpiegatoDAO {
	
	public MySqlImpiegatoDAO() {
        super();
    }

	@Override
	public boolean create(ImpiegatoTO impiegato) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		
		int result = 0;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("create_impiegato"));
			int i = 1;
			statement.setString(i++, impiegato.getCf());
			statement.setString(i++, impiegato.getNome());
			statement.setString(i++, impiegato.getCognome());
			statement.setDate  (i++, java.sql.Date.valueOf(impiegato.getDataNascita()));
			statement.setString(i++, impiegato.getTelefono());
			statement.setString(i++, impiegato.getAgenzia());
			statement.setString(i++, impiegato.getUsername());
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
	public ImpiegatoTO read(String cf) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ImpiegatoTO impiegato = null;
		ResultSet resultSet = null;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_impiegato"));
			statement.setString(1, cf);
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				impiegato = new ImpiegatoTO();
				impiegato.setCf(resultSet.getString("cf"));
				impiegato.setNome(resultSet.getString("nome"));
				impiegato.setCognome(resultSet.getString("cognome"));
				impiegato.setDataNascita(resultSet.getDate("data_nascita").toLocalDate());
				impiegato.setTelefono(resultSet.getString("telefono"));
				impiegato.setAgenzia(resultSet.getString("agenzia"));
				impiegato.setUsername(resultSet.getString("username"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return impiegato;
	}
	
	@Override
	public List<ImpiegatoTO> readAll() {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		List<ImpiegatoTO> listImpiegato = new ArrayList<ImpiegatoTO>();;
		ResultSet resultSet = null;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_all_impiegato"));
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				ImpiegatoTO impiegato = new ImpiegatoTO();
				impiegato.setCf(resultSet.getString("cf"));
				impiegato.setNome(resultSet.getString("nome"));
				impiegato.setCognome(resultSet.getString("cognome"));
				impiegato.setDataNascita(resultSet.getDate("data_nascita").toLocalDate());
				impiegato.setTelefono(resultSet.getString("telefono"));
				impiegato.setAgenzia(resultSet.getString("agenzia"));
				impiegato.setUsername(resultSet.getString("username"));
				listImpiegato.add(impiegato);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return listImpiegato;
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
	public List<ImpiegatoTO> readCognome(String cognome) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		List<ImpiegatoTO> listImpiegato = new ArrayList<ImpiegatoTO>();;
		ResultSet resultSet = null;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_cognome_impiegato"));
			statement.setString(1, cognome);
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ImpiegatoTO impiegato = new ImpiegatoTO();
				impiegato.setCf(resultSet.getString("cf"));
				impiegato.setNome(resultSet.getString("nome"));
				impiegato.setCognome(resultSet.getString("cognome"));
				impiegato.setDataNascita(resultSet.getDate("data_nascita").toLocalDate());
				impiegato.setTelefono(resultSet.getString("telefono"));
				impiegato.setAgenzia(resultSet.getString("agenzia"));
				impiegato.setUsername(resultSet.getString("username"));
				listImpiegato.add(impiegato);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return listImpiegato;
	}
	
	@Override
	public boolean update(ImpiegatoTO impiegato) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		int result;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("update_impiegato"));
			int i = 1;
			statement.setString(i++, impiegato.getCf());
			statement.setString(i++, impiegato.getNome());
			statement.setString(i++, impiegato.getCognome());
			statement.setDate  (i++, java.sql.Date.valueOf(impiegato.getDataNascita()));
			statement.setString(i++, impiegato.getTelefono());
			statement.setString(i++, impiegato.getAgenzia());
			statement.setString(i++, impiegato.getUsername());
			statement.setString(i++, impiegato.getCf());
			
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
			statement = conn.prepareStatement(queryFactory.getQuery("delete_impiegato"));
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
