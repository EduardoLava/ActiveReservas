package br.com.active.reservas.bean.itens;
 
import br.com.active.reservas.bean.EntidadeBase;
import br.com.active.reservas.bean.usuario.Usuario;
import br.com.active.reservas.valida.unique.anottation.ValidarUniqueKey;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;


import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import br.com.active.reservas.valida.unique.IValidacaoItemReservavel;

@Entity
@Table(name = "ar_item_reservavel")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
@ValidarUniqueKey(message = "Já existe um item com este código", service = IValidacaoItemReservavel.class)
public @Data class ItemReservavel extends EntidadeBase{

	public ItemReservavel() {}
	
        @Column(name = "codigo", nullable= false, unique= true )
        @NotBlank(message = "Informe o código" )
	private String codigo;

        @NotBlank(message =  "Informe uma descrição")
	@Column(name = "descricao", nullable = false)
	private String descricao;
	

        @NotNull(message = "Selecione um responsável")
	@ManyToOne
	@JoinColumn(name = "id_responsavel") 
	private Usuario responsavel;
	
}
