package br.com.active.reservas.servicos.impl;

import br.com.active.reservas.bean.reserva.ItemReserva;
import br.com.active.reservas.bean.reserva.StatusReserva;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.active.reservas.dao.RepositorioItemReserva;
import br.com.active.reservas.servicos.IServicoBase;

@Service
@Transactional
public class ServicoItemReserva implements IServicoBase<ItemReserva, Long>{

        @Autowired
        private RepositorioItemReserva repositorioItemReserva;
    
	@Override
	public ItemReserva salvar(ItemReserva entidade) {
            
            return this.repositorioItemReserva.save(entidade);
            
	}
	
	@Override
	public void delete(ItemReserva entidae) {
		this.repositorioItemReserva.delete(entidae);
	}
	
	@Override
	public ItemReserva findById(Long id) {
		return this.repositorioItemReserva.findOne(id);
	}

	@Override
	public Iterable<ItemReserva> findAll() {
		return this.repositorioItemReserva.findAll();
	}
        
        public ItemReserva cancelarReserva(Long id){
            
            ItemReserva itemReserva = findById(id);
            
            if(itemReserva != null){
                itemReserva.setStatus(StatusReserva.CANCELADA);
                
               return salvar(itemReserva);
                
            }
            
            throw new IllegalArgumentException("Item inexistente");
            
        }
        
}
