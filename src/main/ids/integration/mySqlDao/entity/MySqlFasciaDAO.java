package main.ids.integration.mySqlDao.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.ids.integration.dao.entity.FasciaDAO;
import main.ids.integration.mySqlDao.dbUtil.DbEntityCloser;
import main.ids.integration.mySqlDao.factory.MySqlConnectionFactory;
import main.ids.transferObjects.FasciaTO;

public class MySqlFasciaDAO extends MySqlEntityDAO implements FasciaDAO {
	
	public MySqlFasciaDAO() {
        super();
    }

	@Override
	public boolean create(FasciaTO fascia) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		
		int result = 0;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("create_fascia"));
			int i = 1;
			statement.setString(i++, fascia.getId());
			statement.setString(i++, fascia.getDescrizione());
			statement.setDouble(i++, fascia.getTariffaGiornaliera());
			statement.setDouble(i++, fascia.getTariffaSettimanale());
			statement.setDouble(i++, fascia.getTariffaKm());
			
			result = statement.executeUpdate();
			
			if(result > 0) response = true;
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
				
		return response;
	}

	@Override
	public FasciaTO read(String id) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		FasciaTO fascia = null;
		ResultSet resultSet = null;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_fascia"));
			statement.setString(1, id);
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				fascia = new FasciaTO();
				fascia.setId(resultSet.getString("id"));
				fascia.setDescrizione(resultSet.getString("descrizione"));
				fascia.setTariffaGiornaliera(resultSet.getDouble("tariffa_giornaliera"));
				fascia.setTariffaSettimanale(resultSet.getDouble("tariffa_settimanale"));
				fascia.setTariffaKm(resultSet.getDouble("tariffa_km"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return fascia;
	}
	
	@Override
	public List<FasciaTO> readAll() {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		List<FasciaTO> listFascia = new ArrayList<FasciaTO>();;
		ResultSet resultSet = null;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_all_fascia"));
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				FasciaTO fascia = new FasciaTO();
				fascia = new FasciaTO();
				fascia.setId(resultSet.getString("id"));
				fascia.setDescrizione(resultSet.getString("descrizione"));
				fascia.setTariffaGiornaliera(resultSet.getDouble("tariffa_giornaliera"));
				fascia.setTariffaSettimanale(resultSet.getDouble("tariffa_settimanale"));
				fascia.setTariffaKm(resultSet.getDouble("tariffa_km"));
				listFascia.add(fascia);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return listFascia;
	}
	
	@Override
	public boolean update(FasciaTO fascia) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		int result;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("update_fascia"));
			int i = 1;
			statement.setString(i++, fascia.getId());
			statement.setString(i++, fascia.getDescrizione());
			statement.setDouble(i++, fascia.getTariffaGiornaliera());
			statement.setDouble(i++, fascia.getTariffaSettimanale());
			statement.setDouble(i++, fascia.getTariffaKm());
			statement.setString(i++, fascia.getId());
			
			result = statement.executeUpdate();
			
			if(result > 0) response = true;
			
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
		// TODO things
		return false;
	}

	@Override
	public boolean isPresent(String id) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		boolean present = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_fascia"));
			statement.setString(1, id);
			
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
		FasciaDAO fasciaDAO = new MySqlFasciaDAO();
		
		/*
		// create
		FasciaTO fascia = new FasciaTO("Y", "moltobella", 20.00, 30.00, 40.00);
		System.out.println(fasciaDAO.create(fascia));
		
		
		// read 
		FasciaTO f = fasciaDAO.read("A");
		System.out.println(f.toString());
		
		
		// readAll
		List<FasciaTO> lf = fasciaDAO.readAll();
		for(FasciaTO fa : lf){
			System.out.println(fa.toString());
		}
		
		
		// update
		FasciaTO fas = new FasciaTO("Y", "verybella", 10.00, 20.00, 50.00);
		System.out.println(fasciaDAO.update(fas));
		
		
		// delete
		
		
		// isPresent
		System.out.println(fasciaDAO.isPresent("A"));
		*/
		
	}
	
}
