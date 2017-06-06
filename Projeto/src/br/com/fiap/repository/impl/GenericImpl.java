package br.com.fiap.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.repository.GenericRepository;

public class GenericImpl<T, K> implements GenericRepository<T, K>{
	
	private EntityManager em;
	private Class<T> classe;
	
	@SuppressWarnings(value = { "all" })
	public GenericImpl(EntityManager em){
		this.em = em;
		classe = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public T save(T entidade) {
		try{
			em.getTransaction().begin();
			em.merge(entidade);
			em.getTransaction().commit();
		return entidade;
		}catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(K codigo) {
		try{
			em.getTransaction().begin();
			T t = em.find(classe, codigo);
			em.remove(t);
			em.getTransaction().commit();
			return true;
		}catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		String name = classe.getSimpleName();
		String queryStr = "FROM " + name + " E";
		Query query = em.createQuery(queryStr);
		return query.getResultList();
	}

	@Override
	public T findById(K codigo) {
		return em.find(classe, codigo);
	}

}
