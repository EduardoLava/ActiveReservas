/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.active.reservas.entity.listener;

import br.com.active.reservas.bean.EntidadeBase;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.PrePersist;

/**
 *
 * @author Eduardo
 */
public class BasicListener {

    @PrePersist 
    public void setDataCriacao(EntidadeBase entidade) {
        entidade.setDataCadastro(LocalDateTime.now());
    }
    
}
