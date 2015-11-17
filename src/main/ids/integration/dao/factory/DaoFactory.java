package main.ids.integration.dao.factory;

import main.ids.integration.dao.entity.*;
import main.ids.integration.mySqlDao.factory.MySqlDaoFactory;

/**
 * Factory per la restituzione dei DAO di ogni entità
 * 
 * @author chris
 *
 */
public abstract class DaoFactory {
	
	/**
	 * Costante per la restituizione dell'implementazione MySQL
	 */
	public static final int MYSQL = 0;
	
	/**
	 * Restituisce il DAO dell'entità 
	 * 
	 * @return DAO per l'entità agenzia
	 */
	public abstract AgenziaDAO getAgenziaDAO();
	
	/**
	 * Restituisce il DAO dell'entità 
	 * 
	 * @return DAO per l'entità account
	 */
	public abstract AccountDAO getAccountDAO();
	
	/**
	 * Restituisce il DAO dell'entità 
	 * 
	 * @return DAO per l'entità auto
	 */
	public abstract AutoDAO getAutoDAO();
	
	/**
	 * Restituisce il DAO dell'entità 
	 * 
	 * @return DAO per l'entità cliente
	 */
	public abstract ClienteDAO getClienteDAO();
	
	/**
	 * Restituisce il DAO dell'entità 
	 * 
	 * @return DAO per l'entità contratto
	 */
	public abstract ContrattoDAO getContrattoDAO();
	
	/**
	 * Restituisce il DAO dell'entità 
	 * 
	 * @return DAO per l'entità fascia
	 */
	public abstract FasciaDAO getFasciaDAO();
	
	/**
	 * Restituisce il DAO dell'entità 
	 * 
	 * @return DAO per l'entità impiegato
	 */
	public abstract ImpiegatoDAO getImpiegatoDAO();
	
	/**
	 * Restituisce il DAO dell'entità 
	 * 
	 * @return DAO per l'entità manager
	 */
	public abstract ManagerDAO getManagerDAO();
	
	/**
	 * Restituisce una implementazione di DaoFactory
	 * 
	 * @param factory Quale DaoFactory 
	 * @return La DaoFactory
	 */
	public static DaoFactory getDAOFactory(int factory) {
        switch (factory) {
            case MYSQL :
                return new MySqlDaoFactory();
            default :
                return null;
        }
    }
}
