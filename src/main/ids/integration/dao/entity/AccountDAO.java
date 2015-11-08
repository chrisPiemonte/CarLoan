package main.ids.integration.dao.entity;

import main.ids.transferObjects.AccountTO;
import main.ids.transferObjects.ImpiegatoTO;

public interface AccountDAO  extends EntityDAO<AccountTO>{
	
	public ImpiegatoTO login(String username, String password);
	
	public String readPassword(String username);
	
}
