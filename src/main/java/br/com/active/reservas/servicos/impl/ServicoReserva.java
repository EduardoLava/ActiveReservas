package br.com.active.reservas.servicos.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.active.reservas.bean.reserva.Reserva;
import br.com.active.reservas.dao.RepositorioReserva;
import br.com.active.reservas.security.session.impl.SessionFacade;
import br.com.active.reservas.servicos.IServicoBase;

@Service
@Transactional
public class ServicoReserva implements IServicoBase<Reserva, Long>{

        @Autowired
        private ServicoItemReserva servicoItemReserva;
    
	@Autowired
	private RepositorioReserva repositorioReserva;

	/*
	 * Save or update
	 */
	@Override
	public Reserva salvar(Reserva entidade) {
            
            Reserva r = this.repositorioReserva.save(entidade);
            
            r.getItens().forEach(i ->{
                i.setReserva(r);
                servicoItemReserva.salvar(i);
            });
            
            return r;
                
	}
	
	@Override
	public void delete(Reserva entidae) {
		this.repositorioReserva.delete(entidae);
	}
	
	@Override
	public Reserva findById(Long id) {
		return this.repositorioReserva
                        .findByIdAndUsuario_id(
                                id, 
                                SessionFacade.getUsuarioLogado().getId()
                        );
	}

	@Override
	public Iterable<Reserva> findAll() {
		return this.repositorioReserva.findAll();
	}
        
        
}
