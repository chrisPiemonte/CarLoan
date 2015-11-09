package main.ids.business.applicationServices;

import java.util.List;

import main.ids.business.businessObjects.FasciaBO;
import main.ids.transferObjects.FasciaTO;

public class GestioneFasce {
	
	private FasciaBO fasciaBO;
	
	public GestioneFasce(){
		this.fasciaBO = new FasciaBO();
	}
	
	public boolean addNewFascia(FasciaTO fascia){
		return this.fasciaBO.add(fascia);
	}
	
	public FasciaTO getFascia(String id){
		return this.fasciaBO.get(id);
	}
	
	public List<FasciaTO> getAll(){
		return this.fasciaBO.getAll();
	}
	
	public boolean update(FasciaTO fascia){
		return this.fasciaBO.update(fascia);
	}
	
	public boolean delete(String id){
		return this.fasciaBO.delete(id);
	}
	
	public boolean exists(String id){
		return this.fasciaBO.exists(id);
	}
	
	
}
