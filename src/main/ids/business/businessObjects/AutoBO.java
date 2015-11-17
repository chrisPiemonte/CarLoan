package main.ids.business.businessObjects;

import java.util.List;

import main.ids.integration.dao.entity.AutoDAO;
import main.ids.integration.dao.factory.DaoFactory;
import main.ids.transferObjects.AutoTO;

/**
 * Business Object che incapsula le operazioni consentite
 * 
 * @author chris
 */
public class AutoBO {

	private AutoDAO dao;
	
	/**
	 * Costruttore chi inizializza il relativo DAO
	 */
	public AutoBO() {
		try {
			this.dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL).getAutoDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean add(AutoTO auto){
		return this.dao.create(auto);
	}
	
	public AutoTO get(String targa){
		return this.dao.read(targa);
	}
	
	public List<AutoTO> getAll(){
		return this.dao.readAll();
	}
	
	public boolean update(AutoTO auto){
		return this.dao.update(auto);
	}
	
	public boolean delete(String targa){
		return this.dao.delete(targa);
	}
	
	public boolean exists(String targa){
		return this.dao.isPresent(targa);
	}
	
	public List<AutoTO> getAgenzia(String agenzia){
		return this.dao.readAgenzia(agenzia);
	}
	
	public List<AutoTO> getFascia(String fascia){
		return this.dao.readFascia(fascia);
	}
	
	public List<AutoTO> getStato(String stato){
		return this.dao.readStato(stato);
	}
	
	public boolean changeStato(String targa, String newStato){
		return this.dao.updateStato(targa, newStato);
	}
	
	public boolean changeKm(String targa, double newKm){
		return this.dao.updateKm(targa, newKm);
	}
	
	public boolean isAvailable(String targa){
		return this.dao.isDisponibile(targa);
	}
	
}
