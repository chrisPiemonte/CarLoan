package main.ids.integration.dao.entity;

import java.util.List;

public interface EntityDAO<T> {
	
	public boolean create(T elem);
	
	public T read(String id);
	
	public List<T> readAll();
	
	public boolean update(T elem);
	
	public boolean delete(String id);
	
	public boolean isPresent(String id);
	
}
