package main.ids.integration.mySqlDao.entity;

import java.util.List;

import main.ids.integration.dao.entity.ClienteDAO;
import main.ids.transferObjects.ClienteTO;

public class MySqlClienteDAO extends MySqlEntityDAO implements ClienteDAO {
	
	public MySqlClienteDAO() {
        super();
    }

	@Override
	public boolean create(ClienteTO elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ClienteTO read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(ClienteTO elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ClienteTO> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPresent(ClienteTO elem) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
