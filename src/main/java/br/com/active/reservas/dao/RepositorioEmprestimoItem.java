package br.com.active.reservas.dao;
 
import br.com.active.reservas.bean.emprestimo.EmprestimoItem;
import org.springframework.data.repository.*;


public interface RepositorioEmprestimoItem extends CrudRepository<EmprestimoItem, Long> {

}
