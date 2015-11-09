package main.ids.business.applicationServices;

import java.util.List;

import main.ids.business.businessObjects.ManagerBO;
import main.ids.transferObjects.ImpiegatoTO;
import main.ids.transferObjects.ManagerTO;

public class GestioneManager {
	
	private ManagerBO managerBO;
	
	public GestioneManager(){
		this.managerBO = new ManagerBO();
	}

	public boolean addNewManager(ManagerTO manager){
		return this.managerBO.add(manager);
	}
	
	public ManagerTO getManager(String cf){
		return (ManagerTO) this.managerBO.get(cf);
	}
	
	public List<ManagerTO> getAll(){
		return this.managerBO.getAll();
	}
	
	public boolean update(ManagerTO manager){
		return this.managerBO.update(manager);
	}
	
	public boolean delete(String cf){
		return this.managerBO.delete(cf);
	}
	
	public boolean exists(String cf){
		return this.managerBO.exists(cf);
	}
	
	public String getAgenziaOf(String cf){
		return this.managerBO.getAgenzia(cf);
	}
	
	public List<ImpiegatoTO> getByCognome(String cognome){
		return this.managerBO.getCognome(cognome);
	}
	
	public boolean changeAgenziaOf(String cf, String newAgenzia){
		return this.managerBO.changeAgenzia(cf, newAgenzia);
	}
	
}
