package br.com.active.reservas.dao;
 
import br.com.active.reservas.bean.itens.inventario.Ativo;
import br.com.active.reservas.bean.itens.inventario.TipoDeAtivo;
import org.springframework.data.repository.*;


public interface RepositorioAtivo extends CrudRepository<Ativo, Long> {

}
