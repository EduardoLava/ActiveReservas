package br.com.active.reservas.bean;

import br.com.active.reservas.entity.listener.BasicListener;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * 
 * @author Eduardo
 *
 *@MappendSuperclass
 *para a Jpa não criar a entidade base como tabela
 *
 */
@SuppressWarnings("serial")
@MappedSuperclass
@EqualsAndHashCode
@ToString
@EntityListeners(BasicListener.class)
public abstract class EntidadeBase implements Serializable{

	public EntidadeBase() {}

	@Getter
        @Setter
	@GeneratedValue
	@Id
	private Long id;
	
        
	@Getter
        @Setter 
	@Column(name = "data_cadastro", nullable = false)
        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
//        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime dataCadastro;
        
        
        
}
