package br.com.active.reservas.bean.usuario;

public enum TipoUsuario {

	USUARIO("Usuário"),
	FUNCIONARIO("Funcionário"),
	ADMINISTRADOR("Administrador");
	
	public String valor;
	
	private TipoUsuario(String valor) {
		this.valor = valor;
	}
	
}
