package br.com.active.reservas.dao;
 
import br.com.active.reservas.bean.emprestimo.EmprestimoItem;
import br.com.active.reservas.bean.reserva.ItemReserva;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;


public interface RepositorioEmprestimoItem extends CrudRepository<EmprestimoItem, Long> {

    @Query( " select "
            + " ei "
            + "from "
            + "     EmprestimoItem ei "
            + "         join Emprestimo e on e.id = ei.emprestimo.id "
            + "             join UsuarioEmprestimo ue on ue.emprestimo.id = e.id and ue.tipoResponsavelEmprestimo = 'RESPONSAVEL' "
            + " where "
            + "     ue.usuario.id = ?#{[0]} "
            + " order by "
            + "     ei.data asc,"
            + "     ei.itemReservavel.descricao ")
    List<EmprestimoItem> findByUsuario_id(Long id);
    
    @Override
    List<EmprestimoItem> findAll();
    
}
