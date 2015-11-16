package main.ids.integration.mySqlDao.entity;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.ids.integration.dao.entity.AgenziaDAO;
import main.ids.integration.mySqlDao.dbUtil.DbEntityCloser;
import main.ids.integration.mySqlDao.factory.MySqlConnectionFactory;
import main.ids.transferObjects.AgenziaTO;
import main.ids.transferObjects.ImpiegatoTO;
import main.ids.transferObjects.ManagerTO;

public class MySqlAgenziaDAO extends MySqlEntityDAO implements AgenziaDAO{
	
	public MySqlAgenziaDAO() {
        super();
    }

	@Override
	public boolean create(AgenziaTO agenzia) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		
		int result = 0;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("create_agenzia"));
			int i = 1;
			statement.setString(i++, agenzia.getCitta());
			statement.setString(i++, agenzia.getIndirizzo());
			statement.setString(i++, agenzia.getTelefono());
			statement.setString(i++, "aperta");
			
			result = statement.executeUpdate();
			
			if(result > 0){
				response = true;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
				
		return response;
	}

	@Override
	public AgenziaTO read(String id) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		AgenziaTO agenzia = null;
		ResultSet resultSet = null;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_agenzia"));
			statement.setInt(1, Integer.parseInt(id));
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				agenzia = new AgenziaTO();
				agenzia.setId(resultSet.getString("id"));
				agenzia.setCitta(resultSet.getString("citta"));
				agenzia.setIndirizzo(resultSet.getString("indirizzo"));
				agenzia.setTelefono(resultSet.getString("telefono"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return agenzia;
	}

	@Override
	public List<AgenziaTO> readAll() {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		List<AgenziaTO> listAgenzia = new ArrayList<AgenziaTO>();;
		ResultSet resultSet = null;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_all_agenzia"));
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				AgenziaTO agenzia = new AgenziaTO();
				agenzia.setId(resultSet.getString("id"));
				agenzia.setCitta(resultSet.getString("citta"));
				agenzia.setIndirizzo(resultSet.getString("indirizzo"));
				agenzia.setTelefono(resultSet.getString("telefono"));
				listAgenzia.add(agenzia);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return listAgenzia;
	}
	
	@Override
	public ManagerTO readManager(String id) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ManagerTO manager = null;
		ResultSet resultSet = null;

		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_manager_agenzia"));
			int i = 1;
			statement.setString(i++, id);
			statement.setString(i++, "manager");
			
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
		}catch(NullPointerException e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return manager;
		
	}
	
	@Override
	public List<ImpiegatoTO> readImpiegati(String id) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		List<ImpiegatoTO> listImpiegato = null;
		ResultSet resultSet = null;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_impiegati_agenzia"));
			statement.setString(1, id);
			resultSet = statement.executeQuery();
			listImpiegato = new ArrayList<ImpiegatoTO>();
			
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
		}catch(NullPointerException e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return listImpiegato;
	}

	@Override
	public boolean update(AgenziaTO agenzia) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		int result;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("update_agenzia"));
			int i = 1;
			statement.setString(i++, agenzia.getCitta());
			statement.setString(i++, agenzia.getIndirizzo());
			statement.setString(i++, agenzia.getTelefono());

			statement.setString(i++, agenzia.getId());
			
			result = statement.executeUpdate();
			
			if(result > 0){
				response = true;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return response;
	}
	
	@Override
	public boolean delete(String id) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		int result;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("delete_agenzia"));
			int i = 1;
			
			statement.setString(i++, id);
			result = statement.executeUpdate();
			
			if(result > 0){
				response = true;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			close(id);
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return response;
	}
	
	@Override
	public boolean deleteCitta(String citta) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		int result;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("delete_citta_agenzia"));
			int i = 1;
			
			statement.setString(i++, citta);
			result = statement.executeUpdate();
			System.out.println(result);
			if(result > 0){
				response = true;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return response;
	}
	
	private boolean close(String id) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		int result;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("update_stato_agenzia"));
			int i = 1;
			
			statement.setString(i++, id);
			result = statement.executeUpdate();
			
			if(result > 0){
				response = true;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return response;
	}

	@Override
	public boolean isPresent(String id) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		boolean present = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_agenzia"));
			statement.setInt(1, Integer.parseInt(id));
			
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				present = true;
			}
			
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
