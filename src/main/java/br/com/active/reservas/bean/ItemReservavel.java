package br.com.active.reservas.bean;
 
import br.com.active.reservas.bean.usuario.Usuario;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


import lombok.Getter;
import lombok.Setter;  
import lombok.ToString;

@ToString(callSuper = true)
@MappedSuperclass  
public class ItemReservavel extends EntidadeBase{

	public ItemReservavel() {}
	
	@Getter
	@Setter
	@Column(name = "codigo", nullable= false, unique= true)
        @NotNull
        @Min(1)
	private String codigo;
	
	@Getter
	@Setter
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "id_responsavel") 
	private Usuario responsavel;
	
}
