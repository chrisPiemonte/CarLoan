package main.ids.integration.dao.entity;

import main.ids.transferObjects.ManagerTO;

public interface ManagerDAO  extends EntityDAO<ManagerTO>{
	
	public String readAgenzia(String cf);
	
	public boolean updateAgenzia(String cf, String newAgenzia);
}
