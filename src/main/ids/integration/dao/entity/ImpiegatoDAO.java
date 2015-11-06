package main.ids.integration.dao.entity;

import java.util.List;

import main.ids.transferObjects.ImpiegatoTO;

public interface ImpiegatoDAO extends EntityDAO<ImpiegatoTO> {
	
	public List<ImpiegatoTO> readAgenzia(String agenziaId);
	
	public List<ImpiegatoTO> readCognome(String cognome);
	
	public boolean updateAgenzia(String cf);
	
}
