package main.ids.business.applicationServices;

import java.util.List;

import main.ids.business.businessObjects.AutoBO;
import main.ids.transferObjects.AutoTO;

public class GestioneAuto {
	
	private AutoBO autoBO;
	
	public GestioneAuto(){
		this.autoBO = new AutoBO();
	}

	public boolean addNewAuto(AutoTO auto){
		return this.autoBO.add(auto);
	}
	
	public AutoTO getAuto(String targa){
		return this.autoBO.get(targa);
	}
	
	public List<AutoTO> getAll(){
		return this.autoBO.getAll();
	}
	
	public boolean update(AutoTO auto){
		return this.autoBO.update(auto);
	}
	
	public boolean delete(String targa){
		return this.autoBO.delete(targa);
	}
	
	public boolean exists(String targa){
		return this.autoBO.exists(targa);
	}
	
	public List<AutoTO> getByAgenzia(String agenzia){
		return this.autoBO.getAgenzia(agenzia);
	}
	
	public List<AutoTO> getByFascia(String fascia){
		return this.autoBO.getFascia(fascia);
	}
	
	public List<AutoTO> getByStato(String stato){
		return this.autoBO.getStato(stato);
	}
	
	public boolean changeStatoOf(String targa, String newStato){
		return this.autoBO.changeStato(targa, newStato);
	}
	
	public boolean changeKmOf(String targa, double newKm){
		return this.autoBO.changeKm(targa, newKm);
	}
	
	boolean isAvailable(String targa){
		return this.autoBO.isAvailable(targa);
	}
	
}
