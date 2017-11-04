package br.com.active.reservas.servicos.impl;

import br.com.active.reservas.bean.ItemReservavel;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.active.reservas.dao.RepositorioItemReservavel;
import br.com.active.reservas.servicos.IServicoBase;

@Service
@Transactional
public class ServicoItemReservavel  implements IServicoBase<ItemReservavel, Long>{

    /**
     * equivale ao @Inject do cdi
     */
    @Autowired
    private RepositorioItemReservavel itemReservavel;

    public boolean buscarPorCodigo(String codigo, Long id) {
        System.out.println("cod"+ codigo);
        System.out.println("id"+ id);
        if(id != null){
            return itemReservavel.existsByCodigoNotEqualId(codigo, id);
        }
        
        return itemReservavel.existsByCodigo(codigo);
    }

    @Override
    public ItemReservavel salvar(ItemReservavel entidade) {
        return itemReservavel.save(entidade);
    }

    @Override
    public void delete(ItemReservavel entidade) {
        itemReservavel.delete(entidade);
    }

    @Override
    public ItemReservavel findById(Long id) {
        return itemReservavel.findOne(id);
    }

    @Override
    public Iterable<ItemReservavel> findAll() {
        return itemReservavel.findAll();
    }

}
