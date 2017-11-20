package br.com.active.reservas.bean.reserva;

import br.com.active.reservas.bean.EntidadeBase;
import br.com.active.reservas.bean.itens.ItemReservavel;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Table(name = "ar_item_reserva")
@EqualsAndHashCode(callSuper= true)
@ToString(callSuper = true)
public @Data class ItemReserva extends EntidadeBase{

    public ItemReserva(){}
    
    public ItemReserva(ItemReservavel itemReservavel){
        this.itemReservavel = itemReservavel;
    }
    
    @NotNull(message = "Reserva inválida")
    @JoinColumn(name = "id_reserva", nullable = false)
    @ManyToOne
    private Reserva reserva;
    
    @NotNull(message = "Item inválido")
    @JoinColumn(name = "id_item_reservavel", nullable = false)
    @ManyToOne
    private ItemReservavel itemReservavel;
    
    @NotNull(message = "Informe uma data da reserva")
    @Column(name = "data_reserva", nullable = false)
    private LocalDate dataReserva;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Informe um status")
    @Column(name = "status", nullable = false)
    private StatusReserva status;
    
}
