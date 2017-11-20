/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.active.reservas.security.session.impl;

import br.com.active.reservas.bean.usuario.Usuario;
import br.com.active.reservas.security.session.ISessionFacade;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Eduardo
 */
@Component
public class SessionFacade implements ISessionFacade{

    private static Usuario usuarioLogado;
    
    @Override
    public Authentication getUsuarioAutenticado() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static Usuario getUsuarioLogado() {
        
        if(usuarioLogado == null || usuarioLogado.getId() == null){
            throw new IllegalAccessError("Nenhum usuário presente na sessão");
        }
        
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Usuario usuarioLogado) {
        SessionFacade.usuarioLogado = usuarioLogado;
    }
    
    
    
}
