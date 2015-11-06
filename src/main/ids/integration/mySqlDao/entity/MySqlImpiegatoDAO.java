package main.ids.integration.mySqlDao.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
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
	public ImpiegatoTO read(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<ImpiegatoTO> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<ImpiegatoTO> readAgenzia(String agenziaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImpiegatoTO> readCognome(String cognome) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean update(ImpiegatoTO elem) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean updateAgenzia(String cf) {
		// TODO Auto-generated method stub
		return false;
	}	
	
	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPresent(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String[] args){
		ImpiegatoDAO impDAO = new MySqlImpiegatoDAO();
			
		// create
		ImpiegatoTO im = new ImpiegatoTO("1111111111111111", "gian", "naig", LocalDate.now(), "0881", "004", "g");
		System.out.println(impDAO.create(im));
		
	}
	
}
