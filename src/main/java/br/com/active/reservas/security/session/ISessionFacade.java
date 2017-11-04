/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.active.reservas.security.session;

import org.springframework.security.core.Authentication;

/**
 *
 * @author Eduardo
 */
public interface ISessionFacade {
    
    Authentication getUsuarioAutenticado();
    
}
