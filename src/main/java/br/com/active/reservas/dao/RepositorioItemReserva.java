package br.com.active.reservas.dao;
 
import br.com.active.reservas.bean.reserva.ItemReserva;
import org.springframework.data.repository.*;


/**
 * 
 * @author Eduardo
 */
public interface RepositorioItemReserva extends CrudRepository<ItemReserva, Long> {

//    List<Sala> findByDescricaoLikeOrCodigoLike(String descricao, String codigo);
    
}
