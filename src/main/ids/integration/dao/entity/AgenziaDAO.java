package main.ids.integration.dao.entity;

import java.util.List;

import main.ids.transferObjects.AgenziaTO;
import main.ids.transferObjects.ImpiegatoTO;
import main.ids.transferObjects.ManagerTO;

public interface AgenziaDAO extends EntityDAO<AgenziaTO>{
	
	ManagerTO getManager(String id);
	
	List<ImpiegatoTO> getImpiegati(String id);
	
}
