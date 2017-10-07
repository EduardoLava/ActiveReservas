package br.com.active.reservas.dao;
 
import org.springframework.data.repository.*;

import br.com.active.reservas.bean.usuario.Usuario;

public interface RepositorioUsuario extends CrudRepository<Usuario, Long> {

}
