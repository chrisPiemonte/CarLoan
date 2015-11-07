package main.ids.integration.dao.entity;

import java.util.List;

import main.ids.transferObjects.AutoTO;

public interface AutoDAO extends EntityDAO<AutoTO>{
	
	public List<AutoTO> readAgenzia(String agenzia);
	
	public List<AutoTO> readFascia(String fascia);
	
	public List<AutoTO> readStato(String stato);
	
	public boolean updateStato(String targa, String newStato);
	
	public boolean updateKm(String targa, double newKm);
	
	boolean isDisponibile(String targa);
	
}
