package br.com.active.reservas.servicos;

import java.io.Serializable;


public interface ServicoBase<T, ID extends Serializable >{

	T salvar(T entidade);
	
	void delete(T entidade);
	
	T findById(ID entidade);
	
	Iterable<T> findAll(); 
	
}
