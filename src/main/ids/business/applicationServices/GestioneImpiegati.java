package main.ids.business.applicationServices;

import java.util.List;

import main.ids.business.businessObjects.ImpiegatoBO;
import main.ids.transferObjects.ImpiegatoTO;

public class GestioneImpiegati {
	
	private ImpiegatoBO impiegatoBO;
	
	public GestioneImpiegati(){
		this.impiegatoBO = new ImpiegatoBO();
	}
	
	public boolean addNewImpiegato(ImpiegatoTO impiegato){
		return this.impiegatoBO.add(impiegato);
	}
	
	public ImpiegatoTO getImpiegato(String cf){
		return this.impiegatoBO.get(cf);
	}
	
	public List<ImpiegatoTO> getAll(){
		return this.impiegatoBO.getAll();
	}
	
	public boolean update(ImpiegatoTO impiegato){
		return this.impiegatoBO.update(impiegato);
	}
	
	public boolean delete(String cf){
		return this.impiegatoBO.delete(cf);
	}
	
	public boolean exists(String cf){
		return this.impiegatoBO.exists(cf);
	}

	public String getAgenziaOf(String cf){
		return this.impiegatoBO.getAgenzia(cf);
	}
	
	public List<ImpiegatoTO> getByCognome(String cognome){
		return this.impiegatoBO.getCognome(cognome);
	}
	
	public boolean changeAgenziaOf(String cf, String newAgenzia){
		return this.impiegatoBO.changeAgenzia(cf, newAgenzia);
	}
	
	
}
