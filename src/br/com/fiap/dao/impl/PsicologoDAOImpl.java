package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PsicologoDAO;
import br.com.fiap.entity.Psicologo;

public class PsicologoDAOImpl extends GenericDAOImpl<Psicologo, Integer> implements PsicologoDAO{

	public PsicologoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
