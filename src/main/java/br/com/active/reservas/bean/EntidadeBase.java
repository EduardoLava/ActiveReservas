package br.com.active.reservas.bean;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
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
public abstract class EntidadeBase implements Serializable{

	public EntidadeBase() {}

	@Getter
	@GeneratedValue
	@Id
	private Long id;
	
}
