package br.com.active.reservas.dao;
 
import br.com.active.reservas.bean.ItemReservavel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositorioItemReservavel extends JpaRepository<ItemReservavel, Long> {

    boolean existsByCodigo(String codigo);
    
    
}
