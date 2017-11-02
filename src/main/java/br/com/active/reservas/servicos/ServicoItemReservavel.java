package br.com.active.reservas.servicos;

import br.com.active.reservas.bean.ItemReservavel;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.active.reservas.dao.RepositorioItemReservavel;

@Service
@Transactional
public class ServicoItemReservavel  {

    /**
     * equivale ao @Inject do cdi
     */
    @Autowired
    private RepositorioItemReservavel itemReservavel;

    public boolean buscarPorCodigo(String codigo) {
        return itemReservavel.existsByCodigo(codigo);
    }

}
