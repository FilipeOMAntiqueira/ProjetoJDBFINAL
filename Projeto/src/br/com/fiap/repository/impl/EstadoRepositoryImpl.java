package br.com.fiap.repository.impl;

import javax.persistence.EntityManager;

import br.com.fiap.model.Estado;
import br.com.fiap.repository.EstadoRepository;

public class EstadoRepositoryImpl extends GenericImpl<Estado, Integer> implements EstadoRepository{

	public EstadoRepositoryImpl(EntityManager em) {
		super(em);
	}

}
