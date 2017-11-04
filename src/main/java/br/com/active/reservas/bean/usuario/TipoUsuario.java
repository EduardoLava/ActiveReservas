package br.com.active.reservas.bean.usuario;

import java.util.Arrays;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum TipoUsuario {

    USUARIO(
            "Usuário",
            Arrays.asList(
                    new SimpleGrantedAuthority("ROLE_USUARIO")
            )
    ),
    FUNCIONARIO(
            "Funcionário",
            Arrays.asList(
                    new SimpleGrantedAuthority("ROLE_USUARIO"),
                    new SimpleGrantedAuthority("ROLE_FUNCIONARIO")
            )
    ),
    ADMINISTRADOR(
            "Administrador",
            Arrays.asList(
                    new SimpleGrantedAuthority("ROLE_USUARIO"),
                    new SimpleGrantedAuthority("ROLE_FUNCIONARIO"),
                    new SimpleGrantedAuthority("ROLE_ADMINISTRADOR")
            )
    );

    private final String valor;
    private final List<SimpleGrantedAuthority> funcoes;

    private TipoUsuario(String valor, List<SimpleGrantedAuthority> funcoes) {
        this.valor = valor;
        this.funcoes = funcoes;
    }

    public List<SimpleGrantedAuthority> getFuncoes() {
        return funcoes;
    }

    public String getValor() {
        return valor;
    }

}
