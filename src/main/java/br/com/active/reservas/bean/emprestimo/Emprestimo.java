package br.com.active.reservas.bean.emprestimo;

import br.com.active.reservas.bean.EntidadeBase;
import br.com.active.reservas.bean.emprestimo.responsavel.UsuarioEmprestimo;
import br.com.active.reservas.bean.reserva.Reserva;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
@Entity
@Table(name = "ar_emprestimo")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public @Data class Emprestimo extends EntidadeBase {

    public Emprestimo(){
        
    }

    public Emprestimo(StatusEmprestimo statusEmprestimo, Reserva reserva, List<UsuarioEmprestimo> usuarios, List<EmprestimoItem> emprestimoItems) {
        this.statusEmprestimo = statusEmprestimo;
        this.reserva = reserva;
        this.usuarios = usuarios;
        this.emprestimoItems = emprestimoItems;
    }
    
    
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status_emprestimo", nullable = false)
    private StatusEmprestimo statusEmprestimo;
    
    @OneToOne
    @JoinColumn(name = "id_reserva", nullable = true) 
    private Reserva reserva;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany
    private List<UsuarioEmprestimo> usuarios;
    
    @Fetch(FetchMode.SUBSELECT)
    @OneToMany
    private List<EmprestimoItem> emprestimoItems;
}
