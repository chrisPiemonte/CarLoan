package main.ids.business.businessObjects;

import java.time.LocalDate;
import java.util.List;

import main.ids.integration.dao.entity.ContrattoDAO;
import main.ids.integration.dao.factory.DaoFactory;
import main.ids.transferObjects.ContrattoTO;

/**
 * Business Object che incapsula le operazioni consentite
 * 
 * @author chris
 */
public class ContrattoBO {
	
	private ContrattoDAO dao;
	
	/**
	 * Costruttore chi inizializza il relativo DAO
	 */
	public ContrattoBO() {
		try {
			this.dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL).getContrattoDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean add(ContrattoTO contratto){
		return this.dao.create(contratto);
	}
	
	public ContrattoTO get(String id){
		return this.dao.read(id);
	}
	
	public List<ContrattoTO> getAll(){
		return this.dao.readAll();
	}
	
	public boolean update(ContrattoTO contratto){
		return this.dao.update(contratto);
	}
	
	public boolean delete(String id){
		return this.dao.delete(id);
	}
	
	public boolean exists(String id){
		return this.dao.isPresent(id);
	}
	
	public boolean changeModNoleggio(String id, String newModNoleggio){
		return this.dao.updateModNoleggio(id, newModNoleggio);
	}
	
	public boolean changeDataFine(String id, LocalDate newDataFine){
		return this.dao.updateDataFine(id, newDataFine);
	}
	
	public boolean changeAgenziaFine(String id, String newAgenziaFine){
		return this.dao.updateAgenziaFine(id, newAgenziaFine);
	}
	
	public boolean chiudiContratto(String id, String impFine, double kmPercorsi, double totale){
		return this.dao.updateChiudiContratto(id, impFine, kmPercorsi, totale);
	}
	
}
