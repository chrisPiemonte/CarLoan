package main.ids.integration.dao.entity;

import java.util.List;

import main.ids.transferObjects.ImpiegatoTO;

public interface ImpiegatoDAO extends EntityDAO<ImpiegatoTO> {
	
	public String readAgenzia(String cf);
	
	public List<ImpiegatoTO> readCognome(String cognome);
	
	public boolean updateAgenzia(String cf, String newAgenzia);
	
}
