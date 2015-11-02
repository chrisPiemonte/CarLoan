package main.ids.integration.dao.factory;

import main.ids.integration.dao.entity.*;
import main.ids.integration.mySqlDao.factory.MySqlDaoFactory;

public abstract class DaoFactory {
	
	public static final int MYSQL = 0;
	
	public abstract AgenziaDAO getAgenziaDAO();
	
	public abstract AutoDAO getAutoDAO();
	
	public abstract ClienteDAO getClienteDAO();
	
	public abstract ContrattoDAO getContrattoDAO();
	
	public abstract FasciaDAO getFasciaDAO();
	
	public abstract ImpiegatoDAO getImpiegatoDAO();
	
	public abstract ManagerDAO getManagerDAO();
	
	public static DaoFactory getDAOFactory(int factory) {
        switch (factory) {
            case MYSQL :
                return new MySqlDaoFactory();
            default :
                return null;
        }
    }
}
