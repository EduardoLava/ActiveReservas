package br.com.active.reservas.bean.emprestimo;

import br.com.active.reservas.bean.EntidadeBase;
import br.com.active.reservas.bean.itens.ItemReservavel;
import br.com.active.reservas.bean.reserva.Reserva;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
@Entity
@Table(name = "ar_emprestimo_item")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public @Data class EmprestimoItem extends EntidadeBase {

    public EmprestimoItem(){
        
    }
    
    @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;
    
    @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "hora_devolucao", nullable = true)
    private LocalTime horaDevolucao;  
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data", nullable = false)
    private LocalDate data;
    
    @OneToOne
    @JoinColumn(name = "id_item_reservavel")
    private ItemReservavel itemReservavel;
    
    @ManyToOne
    @JoinColumn(name = "id_emprestimo")
    private Emprestimo emprestimo;

}
