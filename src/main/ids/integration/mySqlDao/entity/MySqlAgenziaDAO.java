package main.ids.integration.mySqlDao.entity;

import java.util.List;

import main.ids.integration.dao.entity.AgenziaDAO;
import main.ids.transferObjects.AgenziaTO;
import main.ids.transferObjects.ImpiegatoTO;
import main.ids.transferObjects.ManagerTO;

public class MySqlAgenziaDAO extends MySqlEntityDAO implements AgenziaDAO{
	
	public MySqlAgenziaDAO() {
        super();
    }

	@Override
	public boolean create(AgenziaTO elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AgenziaTO read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(AgenziaTO elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AgenziaTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPresent(AgenziaTO elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ManagerTO getManager(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImpiegatoTO> getImpiegati(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
