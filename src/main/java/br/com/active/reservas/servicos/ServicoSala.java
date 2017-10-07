package br.com.active.reservas.servicos;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.active.reservas.bean.sala.Sala;
import br.com.active.reservas.dao.RepositorioSala;

@Service
@Transactional
public class ServicoSala implements ServicoBase<Sala, Long>{

	/**
	 * equivale ao @Inject do cdi
	 */
	@Autowired
	private RepositorioSala repositorioSala;

	/*
	 * Save or update
	 */
	@Override
	public Sala salvar(Sala entidade) {
		return this.repositorioSala.save(entidade);
	}
	
	@Override
	public void delete(Sala entidae) {
		this.repositorioSala.delete(entidae);
	}
	
	@Override
	public Sala findById(Long id) {
		return this.repositorioSala.findOne(id);
	}

	@Override
	public Iterable<Sala> findAll() {
		return this.repositorioSala.findAll();
	}

	
}
