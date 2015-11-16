package main.ids.integration.mySqlDao.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.ids.integration.dao.entity.AutoDAO;
import main.ids.integration.mySqlDao.dbUtil.DbEntityCloser;
import main.ids.integration.mySqlDao.factory.MySqlConnectionFactory;
import main.ids.transferObjects.AutoTO;

public class MySqlAutoDAO extends MySqlEntityDAO implements AutoDAO{
	
	public MySqlAutoDAO() {
        super();
    }

	@Override
	public boolean create(AutoTO auto) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		
		int result = 0;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("create_auto"));
			int i = 1;
			statement.setString(i++, auto.getTarga());
			statement.setString(i++, auto.getModello());
			statement.setString(i++, auto.getStato());
			statement.setString(i++, auto.getFascia());
			statement.setDouble(i++, auto.getKm());
			statement.setDate  (i++, java.sql.Date.valueOf(auto.getManutenzioneOrdinaria()));
			statement.setString(i++, auto.getAgenzia());
			
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
	public AutoTO read(String targa) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		AutoTO auto = null;
		ResultSet resultSet = null;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_auto"));
			statement.setString(1, targa);
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				auto = new AutoTO();
				auto.setTarga(resultSet.getString("targa"));
				auto.setModello(resultSet.getString("modello"));
				auto.setStato(resultSet.getString("stato"));
				auto.setFascia(resultSet.getString("fascia"));
				auto.setKm(resultSet.getDouble("km"));
				auto.setManutenzioneOrdinaria(resultSet.getDate("manutenzione_ord").toLocalDate());
				auto.setAgenzia(resultSet.getString("agenzia"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return auto;
	}

	@Override
	public List<AutoTO> readAll() {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		List<AutoTO> listAuto = new ArrayList<AutoTO>();;
		ResultSet resultSet = null;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_all_auto"));
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				AutoTO auto = new AutoTO();
				auto.setTarga(resultSet.getString("targa"));
				auto.setModello(resultSet.getString("modello"));
				auto.setStato(resultSet.getString("stato"));
				auto.setFascia(resultSet.getString("fascia"));
				auto.setKm(resultSet.getDouble("km"));
				auto.setManutenzioneOrdinaria(resultSet.getDate("manutenzione_ord").toLocalDate());
				auto.setAgenzia(resultSet.getString("agenzia"));
				listAuto.add(auto);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return listAuto;
	}

	@Override
	public List<AutoTO> readAgenzia(String agenzia) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		List<AutoTO> listAuto = new ArrayList<AutoTO>();;
		ResultSet resultSet = null;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_agenzia_auto"));
			statement.setString(1, agenzia);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				AutoTO auto = new AutoTO();
				auto.setTarga(resultSet.getString("targa"));
				auto.setModello(resultSet.getString("modello"));
				auto.setStato(resultSet.getString("stato"));
				auto.setFascia(resultSet.getString("fascia"));
				auto.setKm(resultSet.getDouble("km"));
				auto.setManutenzioneOrdinaria(resultSet.getDate("manutenzione_ord").toLocalDate());
				auto.setAgenzia(resultSet.getString("agenzia"));
				listAuto.add(auto);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return listAuto;
	}

	@Override
	public List<AutoTO> readFascia(String fascia) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		List<AutoTO> listAuto = new ArrayList<AutoTO>();;
		ResultSet resultSet = null;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_fascia_auto"));
			statement.setString(1, fascia);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				AutoTO auto = new AutoTO();
				auto.setTarga(resultSet.getString("targa"));
				auto.setModello(resultSet.getString("modello"));
				auto.setStato(resultSet.getString("stato"));
				auto.setFascia(resultSet.getString("fascia"));
				auto.setKm(resultSet.getDouble("km"));
				auto.setManutenzioneOrdinaria(resultSet.getDate("manutenzione_ord").toLocalDate());
				auto.setAgenzia(resultSet.getString("agenzia"));
				listAuto.add(auto);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return listAuto;
	}

	@Override
	public List<AutoTO> readStato(String stato) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		List<AutoTO> listAuto = new ArrayList<AutoTO>();;
		ResultSet resultSet = null;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_stato_auto"));
			statement.setString(1, stato);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				AutoTO auto = new AutoTO();
				auto.setTarga(resultSet.getString("targa"));
				auto.setModello(resultSet.getString("modello"));
				auto.setStato(resultSet.getString("stato"));
				auto.setFascia(resultSet.getString("fascia"));
				auto.setKm(resultSet.getDouble("km"));
				auto.setManutenzioneOrdinaria(resultSet.getDate("manutenzione_ord").toLocalDate());
				auto.setAgenzia(resultSet.getString("agenzia"));
				listAuto.add(auto);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return listAuto;
	}
	
	@Override
	public boolean update(AutoTO auto) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		int result;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("update_auto"));
			int i = 1;
			statement.setString(i++, auto.getTarga());
			statement.setString(i++, auto.getModello());
			statement.setString(i++, auto.getStato());
			statement.setString(i++, auto.getFascia());
			statement.setDouble(i++, auto.getKm());
			statement.setDate  (i++, java.sql.Date.valueOf(auto.getManutenzioneOrdinaria()));
			statement.setString(i++, auto.getAgenzia());
			statement.setString(i++, auto.getTarga());
			
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
	public boolean updateStato(String targa, String newStato) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		int result;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("update_stato_auto"));
			int i = 1;
			statement.setString(i++, newStato);
			statement.setString(i++, targa);
			
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
	public boolean updateKm(String targa, double newKm) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		int result;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("update_km_auto"));
			int i = 1;
			statement.setDouble(i++, newKm);
			statement.setString(i++, targa);
			
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
	public boolean delete(String targa) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		int result;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("delete_auto"));
			int i = 1;
			statement.setString(i++, targa);
			
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
	public boolean isDisponibile(String targa) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		boolean disponibile = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_auto"));
			statement.setString(1, targa);
			
			resultSet = statement.executeQuery();
			if(resultSet.next() && resultSet.getString("stato").equals("D")) disponibile = true;
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return disponibile;
	}

	@Override
	public boolean isPresent(String targa) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		boolean present = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_auto"));
			statement.setString(1, targa);
			
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
