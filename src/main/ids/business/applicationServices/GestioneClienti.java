package main.ids.business.applicationServices;

import java.util.List;

import main.ids.business.businessObjects.ClienteBO;
import main.ids.transferObjects.ClienteTO;

public class GestioneClienti {
	
	private ClienteBO clienteBO;
	
	public GestioneClienti(){
		this.clienteBO = new ClienteBO();
	}
	
	public boolean addNewCliente(ClienteTO cliente){
		return this.clienteBO.add(cliente);
	}
	
	public ClienteTO getCliente(String cf){
		return this.clienteBO.get(cf);
	}
	
	public List<ClienteTO> getAll(){
		return this.clienteBO.getAll();
	}
	
	public boolean update(ClienteTO cliente){
		return this.clienteBO.update(cliente);
	}
	
	public boolean delete(String cf){
		return this.clienteBO.delete(cf);
	}
	
	public boolean exists(String cf){
		return this.clienteBO.exists(cf);
	}
	
	public List<ClienteTO> getByCognome(String cognome){
		return this.clienteBO.getByCognome(cognome);
	}
	
	
}
