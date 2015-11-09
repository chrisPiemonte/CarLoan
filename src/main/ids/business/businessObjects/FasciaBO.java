package main.ids.business.businessObjects;

import java.util.List;

import main.ids.integration.dao.entity.FasciaDAO;
import main.ids.integration.dao.factory.DaoFactory;
import main.ids.transferObjects.FasciaTO;

public class FasciaBO {

	private FasciaDAO dao;

	public FasciaBO() {
		try {
			this.dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL).getFasciaDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean add(FasciaTO fascia){
		return this.dao.create(fascia);
	}
	
	public FasciaTO get(String id){
		return this.dao.read(id);
	}
	
	public List<FasciaTO> getAll(){
		return this.dao.readAll();
	}
	
	public boolean update(FasciaTO fascia){
		return this.dao.update(fascia);
	}
	
	public boolean delete(String id){
		return this.dao.delete(id);
	}
	
	public boolean exists(String id){
		return this.dao.isPresent(id);
	}
	
}
