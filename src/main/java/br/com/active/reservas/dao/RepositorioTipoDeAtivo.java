package br.com.active.reservas.dao;
 
import br.com.active.reservas.bean.itens.inventario.StatusTipoAtivo;
import br.com.active.reservas.bean.itens.inventario.TipoDeAtivo;
import java.util.List;
import org.springframework.data.repository.*;


public interface RepositorioTipoDeAtivo extends CrudRepository<TipoDeAtivo, Long> {

    List<TipoDeAtivo> findByStatusTipoAtivo(StatusTipoAtivo statusTipoAtivo);
    
}
