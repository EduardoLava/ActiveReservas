package br.com.active.reservas.bean.itens.inventario;

import br.com.active.reservas.bean.EntidadeBase;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
@Table(name = "ar_tipo_de_ativo")
@EqualsAndHashCode(callSuper= true)
@ToString(callSuper = true)
public @Data class TipoDeAtivo extends EntidadeBase{

        @NotBlank(message = "Informe uma descrição")
	@Column(name = "descricao", nullable = false)
	private String descricao;
        
        @Enumerated(EnumType.STRING)
        @NotNull(message = "Selecione um status")
        @Column(name = "status", nullable = false)
        private StatusTipoAtivo statusTipoAtivo;
	
}
