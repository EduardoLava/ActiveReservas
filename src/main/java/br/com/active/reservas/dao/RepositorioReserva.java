package br.com.active.reservas.dao;
 
import org.springframework.data.repository.*;

import br.com.active.reservas.bean.reserva.Reserva;

/**
 * 
 * @author Eduardo
 */
public interface RepositorioReserva extends CrudRepository<Reserva, Long> {

    Reserva findByIdAndUsuario_id(Long id, Long idUsuario);
    
//    List<Sala> findByDescricaoLikeOrCodigoLike(String descricao, String codigo);
    
}
