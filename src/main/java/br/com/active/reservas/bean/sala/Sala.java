package br.com.active.reservas.bean.sala;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.active.reservas.bean.ItemReservavel;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name = "ar_sala")
@EqualsAndHashCode(callSuper= true)
@ToString(callSuper = true)
@PrimaryKeyJoinColumn(name = "idItemReservavel")
public @Data class Sala extends ItemReservavel{

        @NotNull(message = "Informe a capacidade da sala")
        @Min(value = 1, message = "Informe um valor válido")
	@Column(name = "capacidade")
	private Integer capacidade;
         

	
}
