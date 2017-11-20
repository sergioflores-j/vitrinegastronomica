package br.com.vitrinegastronomica.daos;

import java.util.List;

public interface Dao<T> {
    
	public void save(T t);
	
	public void update(T t);

	public void delete(T t);

	public List<T> listAll();

	public T findById(Long id);
	
}