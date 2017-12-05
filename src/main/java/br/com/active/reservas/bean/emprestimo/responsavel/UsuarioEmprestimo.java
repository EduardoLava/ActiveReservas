package br.com.active.reservas.bean.emprestimo.responsavel;

import br.com.active.reservas.bean.emprestimo.*;
import br.com.active.reservas.bean.EntidadeBase;
import br.com.active.reservas.bean.usuario.Usuario;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Table(name = "ar_usuario_emprestimo")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public @Data class UsuarioEmprestimo extends EntidadeBase {

    public UsuarioEmprestimo(){    
    }
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_responsavel", nullable = false)
    private TipoResponsavelEmprestimo tipoResponsavelEmprestimo;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
   
    @ManyToOne
    @JoinColumn(name = "id_emprestimo", nullable = false)
    private Emprestimo emprestimo;

}
