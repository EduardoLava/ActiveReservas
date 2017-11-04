/**
 * Author:  Eduardo
 * Created: 04/11/2017

 *   deve ser executado antes de inicar os testes

 */

create database if not exists active_reservas;

use active_reservas;

insert into ar_usuario(
	data_cadastro,
	email,
	login,
	nome,
	senha,
	status_usuario,
	tipo_usuario
)values(
	current_timestamp,
	'funcionario@active-reservas.com.br',
	'funcionario',
	'Funcionario de Testes',
	'funcionario',
	'ATIVO',
	'FUNCIONARIO'
);

insert into ar_usuario(
	data_cadastro,
	email,
	login,
	nome,
	senha,
	status_usuario,
	tipo_usuario
)values(
	current_timestamp,
	'administrador@active-reservas.com.br',
	'administrador',
	'Administrador de Testes',
	'administrador',
	'ATIVO',
	'ADMINISTRADOR'
);

insert into ar_usuario(
	data_cadastro,
	email,
	login,
	nome,
	senha,
	status_usuario,
	tipo_usuario
)values(
	current_timestamp,
	'usuario@active-reservas.com.br',
	'usuario',
	'Usuário de Testes',
	'usuario',
	'ATIVO',
	'USUARIO'
);