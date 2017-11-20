package br.com.active.reservas.bean.reserva;

import br.com.active.reservas.bean.EntidadeBase;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.active.reservas.bean.usuario.Usuario;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@SuppressWarnings("serial")
@Entity
@Table(name = "ar_reserva")
@EqualsAndHashCode(callSuper= true)
@ToString(callSuper = true)
public @Data class Reserva extends EntidadeBase{

    public Reserva(Usuario usuario, List<ItemReserva> itens) {
        this.usuario = usuario;
        this.itens = itens;
    }

    public Reserva() {
    }

    
    
    @NotNull(message = "Usuário da reserva inválido")
    @JoinColumn(name = "id_usuario_reservou", nullable = false)
    @ManyToOne
    private Usuario usuario;
 
    
    @Fetch(FetchMode.SUBSELECT)
    @OneToMany
    private List<ItemReserva> itens;
    
}
