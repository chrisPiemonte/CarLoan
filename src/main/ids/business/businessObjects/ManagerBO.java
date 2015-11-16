package main.ids.business.businessObjects;

import java.util.List;

import main.ids.integration.dao.entity.ImpiegatoDAO;
import main.ids.integration.dao.entity.ManagerDAO;
import main.ids.integration.dao.factory.DaoFactory;
import main.ids.transferObjects.ImpiegatoTO;
import main.ids.transferObjects.ManagerTO;

public class ManagerBO {

	private ManagerDAO dao;

	public ManagerBO() {
		try {
			this.dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL).getManagerDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean add(ManagerTO manager){
		return this.dao.create(manager);
	}
	
	public ManagerTO get(String cf){
		return (ManagerTO) this.dao.read(cf);
	}
	
	public List<ManagerTO> getAll(){
		List<ManagerTO> manList = this.dao.readAll();
		return manList;
	}
	
	public boolean update(ManagerTO manager){
		return this.dao.update(manager);
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
	
	public boolean changeAgenzia(String cf, String newAgenzia){
		return this.dao.updateAgenzia(cf, newAgenzia);
	}
	
}
