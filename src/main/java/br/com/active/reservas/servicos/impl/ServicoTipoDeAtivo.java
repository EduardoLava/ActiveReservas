package br.com.active.reservas.servicos.impl;

import br.com.active.reservas.bean.itens.inventario.StatusTipoAtivo;
import br.com.active.reservas.bean.itens.inventario.TipoDeAtivo;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.active.reservas.dao.RepositorioTipoDeAtivo;
import br.com.active.reservas.servicos.IServicoBase;
import java.util.List;

@Service
@Transactional
public class ServicoTipoDeAtivo implements IServicoBase<TipoDeAtivo, Long>{

	/**
	 * equivale ao @Inject do cdi
	 */
	@Autowired
	private RepositorioTipoDeAtivo repositorioTipoDeAtivo;

	/*
	 * Save or update
	 */
	@Override
	public TipoDeAtivo salvar(TipoDeAtivo entidade) {
		return this.repositorioTipoDeAtivo.save(entidade);
	}
	
	@Override
	public void delete(TipoDeAtivo entidae) {
		this.repositorioTipoDeAtivo.delete(entidae);
	}
	
	@Override
	public TipoDeAtivo  findById(Long id) {
		return this.repositorioTipoDeAtivo.findOne(id);
	}

	@Override
	public Iterable<TipoDeAtivo> findAll() {
		return this.repositorioTipoDeAtivo.findAll();
	}
        
        public List<TipoDeAtivo> findTiposDeAtivosAtivos(){
            return this.repositorioTipoDeAtivo.findByStatusTipoAtivo(StatusTipoAtivo.ATIVO);
        }
       
        
}
