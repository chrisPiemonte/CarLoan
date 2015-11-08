package main.ids.integration.mySqlDao.factory;

import main.ids.integration.dao.entity.*;
import main.ids.integration.mySqlDao.entity.*;
import main.ids.integration.dao.factory.DaoFactory;

public class MySqlDaoFactory extends DaoFactory{

	@Override
	public AgenziaDAO getAgenziaDAO() {
		return (MySqlAgenziaDAO) getEntityDao(MySqlAgenziaDAO.class);
	}

	@Override
	public AccountDAO getAccountDAO() {
		return (MySqlAccountDAO) getEntityDao(MySqlAccountDAO.class);
	}
	
	@Override
	public AutoDAO getAutoDAO() {
		return (MySqlAutoDAO) getEntityDao(MySqlAutoDAO.class);
	}

	@Override
	public ClienteDAO getClienteDAO() {
		return (MySqlClienteDAO) getEntityDao(MySqlClienteDAO.class);
	}

	@Override
	public ContrattoDAO getContrattoDAO() {
		return (MySqlContrattoDAO) getEntityDao(MySqlContrattoDAO.class);
	}

	@Override
	public FasciaDAO getFasciaDAO() {
		return (MySqlFasciaDAO) getEntityDao(MySqlFasciaDAO.class);
	}

	@Override
	public ImpiegatoDAO getImpiegatoDAO() {
		return (MySqlImpiegatoDAO) getEntityDao(MySqlImpiegatoDAO.class);
	}

	@Override
	public ManagerDAO getManagerDAO() {
		return (MySqlManagerDAO) getEntityDao(MySqlManagerDAO.class);
	}
	
	private Object getEntityDao(Class<?> daoClass){
		try{
			return daoClass.newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
}
