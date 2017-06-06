package br.com.fiap.repository;

import java.util.List;

public 	interface GenericRepository<T, K> {
	T save(T entidade);
	boolean delete(K codigo);
	List<T> findAll();
	T findById(K codigo);
	
}
