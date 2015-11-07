package main.ids.integration.mySqlDao.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		PreparedStatement accountStatement = null;
		
		int result = 0;
		boolean response = false;
		
		try{
			accountStatement = conn.prepareStatement(queryFactory.getQuery("create_account"));
			int j = 1;
			accountStatement.setString(j++, impiegato.getUsername());
			accountStatement.setString(j++, "d6b558b81ab4503d3ce25c0001513921");
			accountStatement.setString(j++, "impiegato");
			result = accountStatement.executeUpdate();
			if(result > 0) 
				result = 0;
			else 
				return false;
			
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
	
	public static void main(String[] args){
		ImpiegatoDAO impDAO = new MySqlImpiegatoDAO();
		
		/*
		// create
		ImpiegatoTO im = new ImpiegatoTO("1111111111111111", "gian", "naig", LocalDate.now(), "0881", "004", "ggg");
		System.out.println(impDAO.create(im));
		
		
		// read
		ImpiegatoTO imp = impDAO.read("DNTRMN13D14C931Z");
		System.out.println(imp);
		
		
		//read_all
		List<ImpiegatoTO> limp = impDAO.readAll();
		for(ImpiegatoTO imp : limp){
			System.out.println(imp.toString());
		}
		
		
		// read_agenzia
		String agenzia = impDAO.readAgenzia("DNTRMN13D14C931Z");
		System.out.println(agenzia);
		
		
		//read_cognome
		List<ImpiegatoTO> limpi = impDAO.readCognome("Sfrizzo");
		for(ImpiegatoTO imp : limpi){
			System.out.println(imp.toString());
		}
		
		// update
		ImpiegatoTO impie = new ImpiegatoTO("1111111111111111", "giannnnn", "nnnnnnaig", LocalDate.now(), "0881", "004", "ggg");
		System.out.println(impDAO.update(impie));
		
		
		// update_agenzia
		System.out.println(impDAO.updateAgenzia("1111111111111111", "003"));
		
		
		// delete
		System.out.println(impDAO.delete("1111111111111111"));
		
		
		// isPresent
		System.out.println(impDAO.isPresent("1111111111111111"));
		*/
		
		
		
	}
	
}
