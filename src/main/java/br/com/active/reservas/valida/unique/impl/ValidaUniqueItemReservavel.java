/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.active.reservas.valida.unique.impl;

import br.com.active.reservas.bean.ItemReservavel;
import br.com.active.reservas.servicos.ServicoItemReservavel;
import br.com.active.reservas.valida.unique.ValidacaoItemReservavel;
import br.com.active.reservas.valida.unique.ValidacaoUnique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo
 */
@Service
public class ValidaUniqueItemReservavel implements ValidacaoItemReservavel{

    @Autowired
    private ServicoItemReservavel servicoItemReservavel;
    
    @Override
    public boolean validarUnique(Object object) {
        
        return servicoItemReservavel.buscarPorCodigo((String) object);
    }
    
        
}
