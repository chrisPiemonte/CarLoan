package main.ids.integration.mySqlDao.entity;

import java.util.List;

import main.ids.integration.dao.entity.ManagerDAO;
import main.ids.transferObjects.ManagerTO;

public class MySqlManagerDAO extends MySqlEntityDAO implements ManagerDAO{
	
	public MySqlManagerDAO() {
        super();
    }

	@Override
	public boolean create(ManagerTO elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ManagerTO read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(ManagerTO elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ManagerTO> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPresent(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
