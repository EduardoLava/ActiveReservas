package br.com.active.reservas.bean.usuario;

public enum StatusUsuario {

	ATIVO("Ativo"),
	INATIVO("Inativo"),
	AGUARDANDO("Aguardando"),
	RECUSADO("Recusado");
	
	public String valor;
	
	private StatusUsuario(String valor) {
		this.valor = valor;
	}
	
}
