package br.com.active.reservas.servicos.impl;

import br.com.active.reservas.bean.emprestimo.EmprestimoItem;
import br.com.active.reservas.bean.emprestimo.responsavel.UsuarioEmprestimo;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.active.reservas.bean.reserva.Reserva;
import br.com.active.reservas.dao.RepositorioEmprestimoItem;
import br.com.active.reservas.dao.RepositorioReserva;
import br.com.active.reservas.dao.RepositorioUsuarioEmprestimo;
import br.com.active.reservas.security.session.impl.SessionFacade;
import br.com.active.reservas.servicos.IServicoBase;

@Service
@Transactional
public class ServicoEmprestimoItem implements IServicoBase<EmprestimoItem, Long>{

    @Autowired
    private RepositorioEmprestimoItem repositorioEmprestimoItem;

	/*
	 * Save or update
	 */
	@Override
	public EmprestimoItem salvar(EmprestimoItem entidade) {
            
            
            return repositorioEmprestimoItem.save(entidade);
                
	}
	
	@Override
	public void delete(EmprestimoItem entidae) {
		this.repositorioEmprestimoItem.delete(entidae);
	}
	
	@Override
	public EmprestimoItem findById(Long id) {
		return this.repositorioEmprestimoItem
                        .findOne(id);
	}

	@Override
	public Iterable<EmprestimoItem> findAll() {
		return this.repositorioEmprestimoItem.findAll();
	}
        
        
}
