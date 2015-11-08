package main.ids.business.businessObjects;

import java.util.List;

import main.ids.integration.dao.entity.ClienteDAO;
import main.ids.integration.dao.factory.DaoFactory;
import main.ids.transferObjects.ClienteTO;

public class ClienteBO {
	
	private ClienteDAO dao;

	public ClienteBO() {
		try {
			this.dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL).getClienteDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean add(ClienteTO cliente){
		return this.dao.create(cliente);
	}
	
	public ClienteTO get(String cf){
		return this.dao.read(cf);
	}
	
	public List<ClienteTO> getAll(){
		return this.dao.readAll();
	}
	
	public boolean update(ClienteTO cliente){
		return this.dao.update(cliente);
	}
	
	public boolean delete(String cf){
		return this.dao.delete(cf);
	}
	
	public boolean exists(String cf){
		return this.dao.isPresent(cf);
	}
	
	public List<ClienteTO> getByCognome(String cognome){
		return this.dao.readCognome(cognome);
	}
	
}
