/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.active.reservas.security.session.impl;

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

    @Override
    public Authentication getUsuarioAutenticado() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
    
}
