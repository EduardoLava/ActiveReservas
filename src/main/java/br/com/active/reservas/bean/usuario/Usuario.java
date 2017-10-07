package br.com.active.reservas.bean.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.active.reservas.bean.EntidadeBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Table(name = "ar_usuario")
@EqualsAndHashCode(callSuper = true)
public @Data class Usuario extends EntidadeBase{

	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "login", nullable = false, unique = true)
	private String login;
	
	@Column(name = "senha", nullable = false)
	private String senha;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status_usuario", nullable = false)
	private StatusUsuario statusUsuario;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_usuario", nullable = false)
	private TipoUsuario tipoUsuario;
	
}
