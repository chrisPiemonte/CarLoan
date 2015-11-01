package main.ids.integration.dao.entity;

import java.util.List;

import main.ids.transferObjects.AutoTO;

public interface AutoDAO extends EntityDAO<AutoTO>{
	
	boolean isDisponibile(String id);
	
	List<AutoTO> getAutoDisponibili();
	
}
