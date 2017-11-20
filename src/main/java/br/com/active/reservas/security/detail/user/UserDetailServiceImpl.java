/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.active.reservas.security.detail.user;

import br.com.active.reservas.bean.usuario.TipoUsuario;
import br.com.active.reservas.bean.usuario.Usuario;
import br.com.active.reservas.security.session.impl.SessionFacade;
import br.com.active.reservas.servicos.impl.ServicoUsuario;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component(value = "userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private ServicoUsuario userDao;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Usuario user = userDao.buscarUsuarioAtivoPorLogin(login);

        if (user == null) {
            throw new UsernameNotFoundException("Usuário ou senha inválidos.");
        }
        
        SessionFacade.setUsuarioLogado(user);
        
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getSenha(), 
                user.getTipoUsuario().getFuncoes()
        );
        
    }

//    private List getAuthority(TipoUsuario tipoUsuario) {
//        reutrn 
//    }

    public List getUsers() {
        return Arrays.asList("ADMINISTRADOR", "FUNCIONARIO", "USUARIO");
    }

}
