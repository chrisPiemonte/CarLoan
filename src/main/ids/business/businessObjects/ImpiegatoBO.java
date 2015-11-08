package main.ids.business.businessObjects;

import java.util.List;

import main.ids.integration.dao.entity.ImpiegatoDAO;
import main.ids.integration.dao.factory.DaoFactory;
import main.ids.transferObjects.ImpiegatoTO;

public class ImpiegatoBO {

	private ImpiegatoDAO dao;

	public ImpiegatoBO() {
		try {
			this.dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL).getImpiegatoDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public boolean add(ImpiegatoTO impiegato){
		return this.dao.create(impiegato);
	}
	
	public ImpiegatoTO get(String cf){
		return this.dao.read(cf);
	}
	
	public List<ImpiegatoTO> getAll(){
		return this.dao.readAll();
	}
	
	public boolean update(ImpiegatoTO impiegato){
		return this.dao.update(impiegato);
	}
	
	public boolean delete(String cf){
		return this.dao.delete(cf);
	}
	
	public boolean exists(String cf){
		return this.dao.isPresent(cf);
	}
	

	public String getAgenzia(String cf){
		return this.dao.readAgenzia(cf);
	}
	
	public List<ImpiegatoTO> getCognome(String cognome){
		return this.dao.readCognome(cognome);
	}
	
	public boolean changeAgenzia(String cf, String newAgenzia){
		return this.dao.updateAgenzia(cf, newAgenzia);
	}
	
	
}
