package main.ids.integration.mySqlDao.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.ids.integration.dao.entity.ContrattoDAO;
import main.ids.integration.mySqlDao.dbUtil.DbEntityCloser;
import main.ids.integration.mySqlDao.factory.MySqlConnectionFactory;
import main.ids.transferObjects.ContrattoTO;

public class MySqlContrattoDAO extends MySqlEntityDAO implements ContrattoDAO {
	
	public MySqlContrattoDAO() {
        super();
    }

	@Override
	public boolean create(ContrattoTO contratto) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		
		int result = 0;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("create_contratto"));
			int i = 1;
			statement.setString(i++, contratto.getCliente());
			statement.setString(i++, contratto.getAuto());
			statement.setString(i++, contratto.getModNoleggio());
			statement.setString(i++, contratto.getKmNoleggio());
			statement.setDouble(i++, contratto.getPrezzoKm());
			statement.setDate  (i++, java.sql.Date.valueOf(contratto.getDataInizio()));
			statement.setDate  (i++, java.sql.Date.valueOf(contratto.getDataFine()));
			statement.setString(i++, contratto.getAgenziaInizio());
			statement.setString(i++, contratto.getAgenziaFine());
			statement.setString(i++, contratto.getImpInizio());
			statement.setString(i++, contratto.getImpFine());
			statement.setDouble(i++, contratto.getAcconto());
			statement.setDouble(i++, contratto.getKmPercorsi());
			statement.setDouble(i++, contratto.getTariffaBase());
			statement.setString(i++, contratto.getStatoContratto());
			statement.setDouble(i++, contratto.getTotale());
			
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
	public ContrattoTO read(String id) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ContrattoTO contratto = null;
		ResultSet resultSet = null;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_contratto"));
			statement.setInt(1, Integer.parseInt(id));
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				contratto = new ContrattoTO();
				contratto.setId(resultSet.getString("id"));
				contratto.setCliente(resultSet.getString("cliente"));
				contratto.setAuto(resultSet.getString("auto"));
				contratto.setModNoleggio(resultSet.getString("mod_noleggio"));
				contratto.setKmNoleggio(resultSet.getString("km_noleggio"));
				contratto.setPrezzoKm(resultSet.getDouble("prezzo_km"));
				contratto.setDataInizio(resultSet.getDate("data_inizio").toLocalDate());
				contratto.setDataFine(resultSet.getDate("data_fine").toLocalDate());
				contratto.setAgenziaInizio(resultSet.getString("agenzia_inizio"));
				contratto.setAgenziaFine(resultSet.getString("agenzia_fine"));
				contratto.setImpInizio(resultSet.getString("impiegato_inizio"));
				contratto.setImpFine(resultSet.getString("impiegato_fine"));
				contratto.setAcconto(resultSet.getDouble("acconto"));
				contratto.setKmPercorsi(resultSet.getDouble("km_percorsi"));
				contratto.setTariffaBase(resultSet.getDouble("tariffa_base"));
				contratto.setStatoContratto(resultSet.getString("stato_contratto"));
				contratto.setTotale(resultSet.getDouble("totale"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return contratto;
	}

	@Override
	public List<ContrattoTO> readAll() {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		List<ContrattoTO> listContratto = new ArrayList<ContrattoTO>();;
		ResultSet resultSet = null;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("read_all_contratto"));
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				ContrattoTO contratto = new ContrattoTO();
				contratto.setId(resultSet.getString("id"));
				contratto.setCliente(resultSet.getString("cliente"));
				contratto.setAuto(resultSet.getString("auto"));
				contratto.setModNoleggio(resultSet.getString("mod_noleggio"));
				contratto.setKmNoleggio(resultSet.getString("km_noleggio"));
				contratto.setPrezzoKm(resultSet.getDouble("prezzo_km"));
				contratto.setDataInizio(resultSet.getDate("data_inizio").toLocalDate());
				contratto.setDataFine(resultSet.getDate("data_fine").toLocalDate());
				contratto.setAgenziaInizio(resultSet.getString("agenzia_inizio"));
				contratto.setAgenziaFine(resultSet.getString("agenzia_fine"));
				contratto.setImpInizio(resultSet.getString("impiegato_inizio"));
				contratto.setImpFine(resultSet.getString("impiegato_fine"));
				contratto.setAcconto(resultSet.getDouble("acconto"));
				contratto.setKmPercorsi(resultSet.getDouble("km_percorsi"));
				contratto.setTariffaBase(resultSet.getDouble("tariffa_base"));
				contratto.setStatoContratto(resultSet.getString("stato_contratto"));
				contratto.setTotale(resultSet.getDouble("totale"));
				listContratto.add(contratto);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbEntityCloser.close(statement);
			DbEntityCloser.close(conn);
		}
		
		return listContratto;
	}

	@Override
	public boolean update(ContrattoTO elem) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean updateModNoleggio(String id, String newModNoleggio) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		int result;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("update_mod_noleggio_contratto"));
			int i = 1;
			statement.setString(i++, newModNoleggio);
			statement.setString(i++, id);
			
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
	public boolean updateDataFine(String id, LocalDate newDataFine) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		int result;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("update_data_fine_contratto"));
			int i = 1;
			statement.setDate(i++, java.sql.Date.valueOf(newDataFine));
			statement.setString(i++, id);
			
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
	public boolean updateAgenziaFine(String id, String newAgenziaFine) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		int result;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("update_agenzia_fine_contratto"));
			int i = 1;
			statement.setString(i++, newAgenziaFine);
			statement.setString(i++, id);
			
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
	public boolean updateChiudiContratto(String id, String impFine, double kmPercorsi, double totale) {
		Connection conn = MySqlConnectionFactory.getConnection();
		PreparedStatement statement = null;
		int result;
		boolean response = false;
		
		try{
			statement = conn.prepareStatement(queryFactory.getQuery("update_chiudi_contratto"));
			int i = 1;
			statement.setString(i++, impFine);
			statement.setDouble(i++, kmPercorsi);
			statement.setDouble(i++, totale);
			statement.setString(i++, id);
			
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
		/*
		ContrattoDAO contraDAO = new MySqlContrattoDAO();
		
		//create
		ContrattoTO con = new ContrattoTO("QWERTY13A01D447S", "wc333jh", "giornaliero", 
				"limitato", 10, LocalDate.now(), LocalDate.now(), "004","003", 
				"BRNSPN13A35T417Q", "ABRBRS13G71F145H", 10, 10, 10, "aperto", 100);
		System.out.println(contraDAO.create(con));
		
		
		// read
		System.out.println(contraDAO.read("1").toString());
		
		// readAll
		List<ContrattoTO> liC = contraDAO.readAll();
		for(ContrattoTO c : liC){
			System.out.println(c.toString());
		}
		
		
		// update_mod_noleggio
		System.out.println(contraDAO.updateModNoleggio("14", "settimanale"));
		
		
		// update_data_fine
		System.out.println(contraDAO.updateDataFine("14", LocalDate.of(2015, 01, 01)));
		
		
		// update_agenzia_fine
		System.out.println(contraDAO.updateAgenziaFine("14", "001"));
		
		
		// update_data_fine
		System.out.println(contraDAO.updateAgenziaFine("14", "001"));
		
		// update_agenzia_fine
		System.out.println(contraDAO.updateChiudiContratto("14", "GVNCST13D14C931T", 50, 50));
		*/
		
	}
	
}
