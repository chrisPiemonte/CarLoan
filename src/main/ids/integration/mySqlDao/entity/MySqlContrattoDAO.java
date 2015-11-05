package main.ids.integration.mySqlDao.entity;

import java.util.List;

import main.ids.integration.dao.entity.ContrattoDAO;
import main.ids.transferObjects.ContrattoTO;

public class MySqlContrattoDAO extends MySqlEntityDAO implements ContrattoDAO {
	
	public MySqlContrattoDAO() {
        super();
    }
	
	@Override
	public boolean create(ContrattoTO elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ContrattoTO read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(ContrattoTO elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ContrattoTO> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPresent(ContrattoTO elem) {
		// TODO Auto-generated method stub
		return false;
	}

}
