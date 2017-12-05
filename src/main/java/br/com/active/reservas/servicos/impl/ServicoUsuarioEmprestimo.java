package br.com.active.reservas.servicos.impl;

import br.com.active.reservas.bean.emprestimo.responsavel.UsuarioEmprestimo;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.active.reservas.bean.reserva.Reserva;
import br.com.active.reservas.dao.RepositorioReserva;
import br.com.active.reservas.dao.RepositorioUsuarioEmprestimo;
import br.com.active.reservas.security.session.impl.SessionFacade;
import br.com.active.reservas.servicos.IServicoBase;

@Service
@Transactional
public class ServicoUsuarioEmprestimo implements IServicoBase<UsuarioEmprestimo, Long>{

    @Autowired
    private RepositorioUsuarioEmprestimo repositorioUsuarioEmprestimo;

	/*
	 * Save or update
	 */
	@Override
	public UsuarioEmprestimo salvar(UsuarioEmprestimo entidade) {
            
            
            return repositorioUsuarioEmprestimo.save(entidade);
                
	}
	
	@Override
	public void delete(UsuarioEmprestimo entidae) {
		this.repositorioUsuarioEmprestimo.delete(entidae);
	}
	
	@Override
	public UsuarioEmprestimo findById(Long id) {
		return this.repositorioUsuarioEmprestimo
                        .findOne(id);
	}

	@Override
	public Iterable<UsuarioEmprestimo> findAll() {
		return this.repositorioUsuarioEmprestimo.findAll();
	}
        
        
}
