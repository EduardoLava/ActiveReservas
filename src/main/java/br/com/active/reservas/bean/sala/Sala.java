package br.com.active.reservas.bean.sala;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.active.reservas.bean.EntidadeBase;
import br.com.active.reservas.bean.ItemReservavel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Table(name = "ar_sala")
@EqualsAndHashCode(callSuper= true)
@ToString(callSuper = true)
public @Data class Sala extends ItemReservavel{

	@Column(name = "capacidade")
	private Integer capacidade;
         

	
}
