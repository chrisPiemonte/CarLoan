package main.ids.integration.mySqlDao.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.ids.integration.dao.entity.ClienteDAO;
import main.ids.integration.mySqlDao.dbUtil.DbEntityCloser;
import main.ids.integration.mySqlDao.factory.MySqlConnectionFactory;
import main.ids.transferObjects.ClienteTO;

public class MySqlClienteDAO extends MySqlEntityDAO implements ClienteDAO {
	
	public MySqlClienteDAO() {
        super();
    }

	@Override
	public boolean create(ClienteTO cliente) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		
		int result = 0;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("create_cliente"));
			int i = 1;
			statement.setString(i++, cliente.getCf());
			statement.setString(i++, cliente.getNome());
			statement.setString(i++, cliente.getCognome());
			statement.setDate  (i++, java.sql.Date.valueOf(cliente.getDataNascita()));
			statement.setString(i++, cliente.getTelefono());
			
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
	public ClienteTO read(String cf) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ClienteTO cliente = null;
		ResultSet resultSet = null;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_cliente"));
			statement.setString(1, cf);
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				cliente = new ClienteTO();
				cliente.setCf(resultSet.getString("cf"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCognome(resultSet.getString("cognome"));
				cliente.setDataNascita(resultSet.getDate("data_nascita").toLocalDate());
				cliente.setTelefono(resultSet.getString("telefono"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return cliente;
	}
	
	@Override
	public List<ClienteTO> readCognome(String cognome) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		List<ClienteTO> listCliente = new ArrayList<ClienteTO>();;
		ResultSet resultSet = null;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_cognome_cliente"));
			statement.setString(1, cognome);
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ClienteTO cliente = new ClienteTO();
				cliente.setCf(resultSet.getString("cf"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCognome(resultSet.getString("cognome"));
				cliente.setDataNascita(resultSet.getDate("data_nascita").toLocalDate());
				cliente.setTelefono(resultSet.getString("telefono"));
				listCliente.add(cliente);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return listCliente;
	}
	
	@Override
	public List<ClienteTO> readAll() {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		List<ClienteTO> listCliente = new ArrayList<ClienteTO>();;
		ResultSet resultSet = null;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_all_cliente"));
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				ClienteTO cliente = new ClienteTO();
				cliente.setCf(resultSet.getString("cf"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCognome(resultSet.getString("cognome"));
				cliente.setDataNascita(resultSet.getDate("data_nascita").toLocalDate());
				cliente.setTelefono(resultSet.getString("telefono"));
				listCliente.add(cliente);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return listCliente;
	}

	@Override
	public boolean update(ClienteTO cliente) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		int result;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("update_cliente"));
			int i = 1;
			statement.setString(i++, cliente.getCf());
			statement.setString(i++, cliente.getNome());
			statement.setString(i++, cliente.getCognome());
			statement.setDate  (i++, java.sql.Date.valueOf(cliente.getDataNascita()));
			statement.setString(i++, cliente.getTelefono());
			statement.setString(i++, cliente.getCf());
			
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
			statement = conn.prepareStatement(queryFactory.getQuery("delete_cliente"));
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
			statement = conn.prepareStatement(queryFactory.getQuery("read_cliente"));
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
