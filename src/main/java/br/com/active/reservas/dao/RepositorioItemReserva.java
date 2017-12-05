package br.com.active.reservas.dao;
 
import br.com.active.reservas.bean.reserva.ItemReserva;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;


/**
 * 
 * @author Eduardo
 */
public interface RepositorioItemReserva extends CrudRepository<ItemReserva, Long> {

//    List<Sala> findByDescricaoLikeOrCodigoLike(String descricao, String codigo);
    
    @Query( " select it from ItemReserva it join Reserva r on r.id = it.reserva.id where r.usuario.id = ?#{[0]}")
    List<ItemReserva> findByUsuario_id(Long id);
    
    List<ItemReserva> findAll();
    
    @Query( " select it from ItemReserva it join Reserva r on r.id = it.reserva.id where r.usuario.id = ?#{[0]} and it.dataReserva = ?#{[1]}  ")
    List<ItemReserva> findByUsuario_idAndDataReserva(Long id, LocalDate data);
}
