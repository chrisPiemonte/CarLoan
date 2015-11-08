package main.ids.integration.dao.entity;

import java.time.LocalDate;

import main.ids.transferObjects.ContrattoTO;

public interface ContrattoDAO extends EntityDAO<ContrattoTO> {
	
	public boolean updateModNoleggio(String id, String newModNoleggio);
	
	public boolean updateDataFine(String id, LocalDate newDataFine);
	
	public boolean updateAgenziaFine(String id, String newAgenziaFine);
	
	public boolean updateChiudiContratto(String id, String impFine, double kmPercorsi, double totale);
	
}
