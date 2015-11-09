package main.ids.business.applicationServices;

import java.util.List;

import main.ids.business.businessObjects.AccountBO;
import main.ids.transferObjects.AccountTO;
import main.ids.transferObjects.ImpiegatoTO;

public class GestioneAccount {
	
	private AccountBO accountBO;
	
	public GestioneAccount(){
		this.accountBO = new AccountBO();
	}
	
	public ImpiegatoTO login(String username, String password){
		return this.accountBO.login(username, password);
	}

	public boolean addNewAccount(AccountTO account){
		return this.accountBO.add(account);
	}
	
	public AccountTO getAccount(String id){
		return this.accountBO.get(id);
	}
	
	public String getPasswordOf(String username){
		return this.accountBO.getPassword(username);
	}

	public List<AccountTO> getAll(){
		return this.accountBO.getAll();
	}
	
	public boolean update(AccountTO account){
		return this.accountBO.update(account);
	}
	
	public boolean delete(String id){
		return this.accountBO.delete(id);
	}
	
	public boolean exists(String id){
		return this.accountBO.exists(id);
	}
	
}
