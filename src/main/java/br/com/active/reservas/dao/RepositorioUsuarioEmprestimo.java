package br.com.active.reservas.dao;
 
import br.com.active.reservas.bean.emprestimo.responsavel.UsuarioEmprestimo;
import org.springframework.data.repository.*;


public interface RepositorioUsuarioEmprestimo extends CrudRepository<UsuarioEmprestimo, Long> {

}
