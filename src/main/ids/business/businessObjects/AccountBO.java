package main.ids.business.businessObjects;

import java.util.List;

import main.ids.integration.dao.entity.AccountDAO;
import main.ids.integration.dao.factory.DaoFactory;
import main.ids.transferObjects.AccountTO;
import main.ids.transferObjects.ImpiegatoTO;

/**
 * Business Object che incapsula le operazioni consentite
 * 
 * @author chris
 */
public class AccountBO {
	
	private AccountDAO dao;
	
	/**
	 * Costruttore chi inizializza il relativo DAO
	 */
	public AccountBO() {
		try {
			this.dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL).getAccountDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ImpiegatoTO login(String username, String password){
		return this.dao.login(username, password);
	}

	public boolean add(AccountTO account){
		return this.dao.create(account);
	}
	
	public AccountTO get(String id){
		return this.dao.read(id);
	}
	
	public String getPassword(String username){
		return this.dao.readPassword(username);
	}

	public List<AccountTO> getAll(){
		return this.dao.readAll();
	}
	
	public boolean update(AccountTO account){
		return this.dao.update(account);
	}
	
	public boolean delete(String id){
		return this.dao.delete(id);
	}
	
	public boolean exists(String id){
		return this.dao.isPresent(id);
	}
	
}
