package br.com.active.reservas.dao;
 
import org.springframework.data.repository.*;

import br.com.active.reservas.bean.itens.sala.Sala;
import java.util.List;

public interface RepositorioSala extends CrudRepository<Sala, Long> {

    List<Sala> findByDescricaoLikeOrCodigoLike(String descricao, String codigo);
    
}
