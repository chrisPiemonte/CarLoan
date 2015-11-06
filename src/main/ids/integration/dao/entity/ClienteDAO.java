package main.ids.integration.dao.entity;

import java.util.List;

import main.ids.transferObjects.ClienteTO;

public interface ClienteDAO extends EntityDAO<ClienteTO>{
	
	public List<ClienteTO> readCognome(String cognome);
	
}
