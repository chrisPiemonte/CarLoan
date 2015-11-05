package main.ids.integration.mySqlDao.entity;

import java.util.List;

import main.ids.integration.dao.entity.ImpiegatoDAO;
import main.ids.transferObjects.ImpiegatoTO;

public class MySqlImpiegatoDAO extends MySqlEntityDAO implements ImpiegatoDAO {
	
	public MySqlImpiegatoDAO() {
        super();
    }

	@Override
	public boolean create(ImpiegatoTO elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ImpiegatoTO read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(ImpiegatoTO elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ImpiegatoTO> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPresent(ImpiegatoTO elem) {
		// TODO Auto-generated method stub
		return false;
	}	
}
