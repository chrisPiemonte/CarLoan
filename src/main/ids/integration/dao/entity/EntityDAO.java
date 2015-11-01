package main.ids.integration.dao.entity;

import java.util.List;

public interface EntityDAO<T> {
	
	boolean create(T elem);
	
	T read(String id);
	
	boolean update(T elem);
	
	boolean delete(String id);
	
	List<T> getAll();
	
	boolean isPresent(T elem);
	
}
