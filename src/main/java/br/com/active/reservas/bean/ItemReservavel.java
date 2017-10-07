package br.com.active.reservas.bean;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public class ItemReservavel extends EntidadeBase{

	public ItemReservavel() {}
	
	@Getter
	@Setter
	@Column(name = "codigo", nullable= false, unique= true)
	private String codigo;
	
	@Getter
	@Setter
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	// não o spring irá setar o valor automaticamente 
	@Getter
	@CreatedDate
	@Column(name = "data_cadastro", nullable = false)
	private LocalDate dataCadastro;
	
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "id_responsavel")
	private Long idResponsavel;
	
}
