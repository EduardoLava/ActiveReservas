package br.com.active.reservas.dao;
 
import br.com.active.reservas.bean.ItemReservavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface RepositorioItemReservavel extends JpaRepository<ItemReservavel, Long> {

    boolean existsByCodigo(String codigo);
    
    @Query("select count(ir) > 0 from ItemReservavel ir where ir.codigo = ?#{[0]} and ir.id <> ?#{[1]}" )
    boolean existsByCodigoNotEqualId(String codigo, Long id);
    
    
}
