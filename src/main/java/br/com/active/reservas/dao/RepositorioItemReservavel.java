package br.com.active.reservas.dao;
 
import br.com.active.reservas.bean.itens.ItemReservavel;
import br.com.active.reservas.bean.itens.TipoItem;
import br.com.active.reservas.bean.itens.inventario.TipoDeAtivo;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface RepositorioItemReservavel extends JpaRepository<ItemReservavel, Long> {

    boolean existsByCodigo(String codigo);
    
    @Query("select count(ir) > 0 from ItemReservavel ir where ir.codigo = ?#{[0]} and ir.id <> ?#{[1]}" )
    boolean existsByCodigoNotEqualId(String codigo, Long id);
    
    
    List<ItemReservavel> findByTipo(String tipo);
    
    List<ItemReservavel> findByTipoOrderByTipoAscCodigoAsc(TipoItem tipo);
    
    List<ItemReservavel> findAllByOrderByTipoAscCodigoAsc();
    
    @Query(" select "
            + " it "
            + "from "
            + " ItemReservavel it "
            + " INNER JOIN Ativo a on a.idItemReservavel = it.id "
            + "where "
            + " it.tipo = ?#{[0]} "
            + " and a.tipoDeAtivo.id = ?#{[1]} "
            + " and not exists ( "
            + "    select "
            + "         ir "
            + "     from "
            + "         ItemReserva ir "
            + "     where "
            + "         ir.itemReservavel = it "
            + "         and ir.dataReserva = ?#{[2]} "
            + "         and ir.status = 'ATIVA' "
            + " ) "
            + " and not exists ( "
            + "    select "
            + "         emp "
            + "     from "
            + "         Emprestimo emp"
            + "         join EmprestimoItem ei on ei.emprestimo.id = emp.id "
            + "     where "
            + "         ei.itemReservavel = it "
            + "         and ei.data = ?#{[0]} "
            + "         and emp.statusEmprestimo = 'ATIVO' "
            + " ) "
    )
    List<ItemReservavel> findByTipoAndTipoDeAtivoAndNotExistsReserva(
            TipoItem tipo, 
            Long idTipoDeAtivo,
            LocalDate data
    );
    
    @Query(" select "
            + " it "
            + "from "
            + " ItemReservavel it "
            + "where "
            + " it.tipo = ?#{[0]} "
            + " and"
            + " not exists ( "
            + "    select "
            + "         ir "
            + "     from "
            + "         ItemReserva ir "
            + "     where "
            + "         ir.itemReservavel = it "
            + "         and ir.dataReserva = ?#{[1]} "
            + "         and ir.status = 'ATIVA' "
            + " ) "
            + " and not exists ( "
            + "    select "
            + "         emp "
            + "     from "
            + "         Emprestimo emp"
            + "         join EmprestimoItem ei on ei.emprestimo.id = emp.id "
            + "     where "
            + "         ei.itemReservavel = it "
            + "         and ei.data = ?#{[0]} "
            + "         and emp.statusEmprestimo = 'ATIVO' "
            + " ) "
    )
    List<ItemReservavel> findByTipoAndNotExistsReserva(TipoItem tipo, LocalDate data);
    
    @Query(" select "
            + " it "
            + "from "
            + " ItemReservavel it "
            + "where "
            + " not exists ( "
            + "    select "
            + "         ir "
            + "     from "
            + "         ItemReserva ir "
            + "     where "
            + "         ir.itemReservavel = it "
            + "         and ir.dataReserva = ?#{[0]} "
            + "         and ir.status = 'ATIVA' "
            + " ) "
            + " and not exists ( "
            + "    select "
            + "         emp "
            + "     from "
            + "         Emprestimo emp"
            + "         join EmprestimoItem ei on ei.emprestimo.id = emp.id "
            + "     where "
            + "         ei.itemReservavel = it "
            + "         and ei.data = ?#{[0]} "
            + "         and emp.statusEmprestimo = 'ATIVO' "
            + " ) ")
    List<ItemReservavel> findByNotExistsReserva( LocalDate data);
    
    
}
