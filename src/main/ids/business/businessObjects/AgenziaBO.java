package main.ids.business.businessObjects;

import java.util.List;

import main.ids.integration.dao.entity.AgenziaDAO;
import main.ids.integration.dao.factory.DaoFactory;
import main.ids.transferObjects.AgenziaTO;
import main.ids.transferObjects.ImpiegatoTO;
import main.ids.transferObjects.ManagerTO;

public class AgenziaBO {
	 
	
	private AgenziaDAO dao;

	public AgenziaBO() {
		try {
			this.dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL).getAgenziaDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean add(AgenziaTO agenzia){
		return this.dao.create(agenzia);
	}
	
	public AgenziaTO get(String id){
		return this.dao.read(id);
	}

	public List<AgenziaTO> getAll(){
		return this.dao.readAll();
	}
	
	public ManagerTO getManager(String id){
		return this.dao.readManager(id);
	}

	public List<ImpiegatoTO> getImpiegati(String id){
		return this.dao.readImpiegati(id);
	}
	
	public boolean update(AgenziaTO agenzia){
		return this.dao.update(agenzia);
	}
	
	public boolean delete(String id){
		return this.dao.delete(id);
	}
	
	public boolean exists(String id){
		return this.dao.isPresent(id);
	}
	
}
