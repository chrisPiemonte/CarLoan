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
			System.out.println(statement.toString());
			
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
	public boolean update(AgenziaTO elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
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
	public boolean isPresent(AgenziaTO elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ManagerTO getManager(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImpiegatoTO> getImpiegati(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args){
		AgenziaDAO agDAO = new MySqlAgenziaDAO();
		/*
		AgenziaTO agenzia = new AgenziaTO("Torino", "via minchio", "0101010");
		agDAO.create(agenzia);
		*/
		/*
		AgenziaTO ag = agDAO.read("001");
		System.out.println(ag.getId() + " " + ag.getCitta() + " " + ag.getIndirizzo() + " " + ag.getTelefono());
		*/
		List<AgenziaTO> la = agDAO.readAll();
		
		for(AgenziaTO ag : la){
			System.out.println(ag.getId() + " " + ag.getCitta() + " " + ag.getIndirizzo() + " " + ag.getTelefono());
		}
	}
	
}
