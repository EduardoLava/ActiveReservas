package br.com.active.reservas.servicos.impl;

import br.com.active.reservas.bean.itens.inventario.Ativo;
import br.com.active.reservas.dao.RepositorioAtivo;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.active.reservas.servicos.IServicoBase;

@Service
@Transactional
public class ServicoAtivo implements IServicoBase<Ativo, Long>{

	/**
	 * equivale ao @Inject do cdi
	 */
	@Autowired
	private RepositorioAtivo repositorioAtivo;

	/*
	 * Save or update
	 */
	@Override
	public Ativo salvar(Ativo entidade) {
		return this.repositorioAtivo.save(entidade);
	}
	
	@Override
	public void delete(Ativo entidae) {
		this.repositorioAtivo.delete(entidae);
	}
	
	@Override
	public Ativo  findById(Long id) {
		return this.repositorioAtivo.findOne(id);
	}

	@Override
	public Iterable<Ativo> findAll() {
		return this.repositorioAtivo.findAll();
	}
        
}
