package br.com.fiap.repository.impl;

import javax.persistence.EntityManager;

import br.com.fiap.model.Cidade;
import br.com.fiap.repository.CidadeRepository;

public class CidadeRepositoryImpl extends GenericImpl<Cidade, Integer>
implements CidadeRepository{

	public CidadeRepositoryImpl(EntityManager em) {
		super(em);
	}
}
