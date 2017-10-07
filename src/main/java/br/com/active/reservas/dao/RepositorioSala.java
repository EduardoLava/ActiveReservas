package br.com.active.reservas.dao;
 
import org.springframework.data.repository.*;

import br.com.active.reservas.bean.sala.Sala;

public interface RepositorioSala extends CrudRepository<Sala, Long> {

}
