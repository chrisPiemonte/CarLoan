package main.ids.integration.mySqlDao.entity;

import java.util.List;

import main.ids.integration.dao.entity.FasciaDAO;
import main.ids.transferObjects.FasciaTO;

public class MySqlFasciaDAO extends MySqlEntityDAO implements FasciaDAO {
	
	public MySqlFasciaDAO() {
        super();
    }

	@Override
	public boolean create(FasciaTO elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FasciaTO read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(FasciaTO elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<FasciaTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPresent(FasciaTO elem) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
