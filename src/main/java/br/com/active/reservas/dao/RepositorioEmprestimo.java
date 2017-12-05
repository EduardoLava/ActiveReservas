package br.com.active.reservas.dao;
 
import br.com.active.reservas.bean.emprestimo.Emprestimo;
import org.springframework.data.repository.*;


public interface RepositorioEmprestimo extends CrudRepository<Emprestimo, Long> {

}
