package br.com.fiap.repository.impl;

import javax.persistence.EntityManager;

import br.com.fiap.model.Empresa;
import br.com.fiap.repository.EmpresaRepository;

public class EmpresaRepositoryImpl 
		extends GenericImpl<Empresa, Integer> implements EmpresaRepository {

	public EmpresaRepositoryImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
