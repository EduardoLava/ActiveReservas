package br.com.active.reservas.dao;
 
import br.com.active.reservas.bean.usuario.StatusUsuario;
import br.com.active.reservas.bean.usuario.TipoUsuario;
import org.springframework.data.repository.*;

import br.com.active.reservas.bean.usuario.Usuario;
import java.util.List;

public interface RepositorioUsuario extends CrudRepository<Usuario, Long> {

    List<Usuario> findByTipoUsuarioAndStatusUsuario(TipoUsuario tipoUsuario, StatusUsuario statusUsuario);
    
    Usuario findByLoginAndStatusUsuario(String login, StatusUsuario statusUsuario);
    
}
