package main.ids.business.applicationServices;

import java.time.LocalDate;
import java.util.List;

import main.ids.business.businessObjects.ContrattoBO;
import main.ids.transferObjects.ContrattoTO;

public class GestioneContratti {
	
	private ContrattoBO contrattoBO;
	
	public GestioneContratti(){
		this.contrattoBO = new ContrattoBO();
	}

	public boolean apriContratto(ContrattoTO contratto){
		return this.contrattoBO.add(contratto);
	}
	
	public ContrattoTO getContratto(String id){
		return this.contrattoBO.get(id);
	}
	
	public List<ContrattoTO> getAll(){
		return this.contrattoBO.getAll();
	}
	
	public boolean update(ContrattoTO contratto){
		return this.contrattoBO.update(contratto);
	}
	
	public boolean delete(String id){
		return this.contrattoBO.delete(id);
	}
	
	public boolean exists(String id){
		return this.contrattoBO.exists(id);
	}
	
	public boolean changeModNoleggio(String id, String newModNoleggio){
		return this.contrattoBO.changeModNoleggio(id, newModNoleggio);
	}
	
	public boolean changeDataFine(String id, LocalDate newDataFine){
		return this.contrattoBO.changeDataFine(id, newDataFine);
	}
	
	public boolean changeAgenziaFine(String id, String newAgenziaFine){
		return this.contrattoBO.changeAgenziaFine(id, newAgenziaFine);
	}
	
	public boolean chiudiContratto(String id, String impFine, double kmPercorsi, double totale){
		return this.contrattoBO.chiudiContratto(id, impFine, kmPercorsi, totale);
	}
	
	
}
