package main.ids.business.applicationServices;

import java.util.List;

import main.ids.business.businessObjects.AgenziaBO;
import main.ids.transferObjects.AgenziaTO;
import main.ids.transferObjects.ImpiegatoTO;
import main.ids.transferObjects.ManagerTO;

public class GestioneAgenzie {
	
	private AgenziaBO agenziaBO;
	
	public GestioneAgenzie(){
		this.agenziaBO = new AgenziaBO();
	}

	public boolean addNewAgenzia(AgenziaTO agenzia){
		return this.agenziaBO.add(agenzia);
	}
	
	public AgenziaTO getAgenzia(String id){
		return this.agenziaBO.get(id);
	}

	public List<AgenziaTO> getAll(){
		return this.agenziaBO.getAll();
	}
	
	public ManagerTO getManagerOf(String id){
		return this.agenziaBO.getManager(id);
	}

	public List<ImpiegatoTO> getImpiegatiOf(String id){
		return this.agenziaBO.getImpiegati(id);
	}
	
	public boolean update(AgenziaTO agenzia){
		return this.agenziaBO.update(agenzia);
	}
	
	public boolean delete(String id){
		return this.agenziaBO.delete(id);
	}
	
	public boolean deleteCitta(String id){
		return this.agenziaBO.deleteCitta(id);
	}
	
	public boolean exists(String id){
		return this.agenziaBO.exists(id);
	}
	
}
