package main.ids.integration.mySqlDao.entity;

import java.util.List;

import main.ids.integration.dao.entity.AutoDAO;
import main.ids.transferObjects.AutoTO;

public class MySqlAutoDAO extends MySqlEntityDAO implements AutoDAO{
	
	public MySqlAutoDAO() {
        super();
    }

	@Override
	public boolean create(AutoTO elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AutoTO read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(AutoTO elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AutoTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPresent(AutoTO elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDisponibile(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AutoTO> getAutoDisponibili() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
