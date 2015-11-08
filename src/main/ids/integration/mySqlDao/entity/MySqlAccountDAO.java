package main.ids.integration.mySqlDao.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.ids.integration.dao.entity.AccountDAO;
import main.ids.integration.mySqlDao.dbUtil.DbEntityCloser;
import main.ids.integration.mySqlDao.factory.MySqlConnectionFactory;
import main.ids.transferObjects.AccountTO;
import main.ids.util.security.*;

public class MySqlAccountDAO  extends MySqlEntityDAO implements AccountDAO{
	
	Encrypter encrypter = new BaseEncrypter();
	
	public MySqlAccountDAO() {
        super();
    }

	@Override
	public boolean create(AccountTO account) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		Encrypter encrypter = new BaseEncrypter();
		
		int result = 0;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("create_account"));
			int j = 1;
			
			String password = account.getPassword();
			statement.setString(j++, account.getUsername());
			statement.setString(j++, encrypter.encrypt(password));
			statement.setString(j++, account.getRuolo());
			
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
	public AccountTO read(String username) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		AccountTO account = null;
		ResultSet resultSet = null;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_account"));
			statement.setString(1, username);
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				account = new AccountTO();
				String encryptedPassword = resultSet.getString("password");
				account.setUsername(resultSet.getString("username"));
				account.setPassword(encrypter.decrypt(encryptedPassword));
				account.setRuolo(resultSet.getString("ruolo"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return account;
	}

	@Override
	public List<AccountTO> readAll() {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		List<AccountTO> listAccount = new ArrayList<AccountTO>();;
		ResultSet resultSet = null;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_all_account"));
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				AccountTO account = new AccountTO();
				String encryptedPassword = resultSet.getString("password");
				account.setUsername(resultSet.getString("username"));
				account.setPassword(encrypter.decrypt(encryptedPassword));
				account.setRuolo(resultSet.getString("ruolo"));
				listAccount.add(account);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return listAccount;
	}

	@Override
	public boolean update(AccountTO account) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		int result;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("update_account"));
			int i = 1;
			String password = account.getPassword();
			statement.setString(i++, account.getUsername());
			statement.setString(i++, encrypter.encrypt(password));
			statement.setString(i++, account.getRuolo());
			statement.setString(i++, account.getUsername());
			
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
	public boolean delete(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPresent(String username) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		boolean present = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_account"));
			statement.setString(1, username);
			
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
		
		/*
		AccountDAO accDAO = new MySqlAccountDAO();
		// create
		AccountTO ac = new AccountTO("sfaccimmey", "0000", "impiegato");
		System.out.println(accDAO.create(ac));
		
		// read
		System.out.println(accDAO.read("sfaccimmey").toString());
		
		// read_all
		List<AccountTO> accList = accDAO.readAll();
		for(AccountTO a : accList){
			System.out.println(a.toString());
		}
		
		// update
		AccountTO acco = new AccountTO("sfaccimmey", "1111", "manager");
		System.out.println(accDAO.update(acco));
		
		// isPresent
		System.out.println(accDAO.isPresent("sfaccimmey"));
		*/
		
	}
	
}
