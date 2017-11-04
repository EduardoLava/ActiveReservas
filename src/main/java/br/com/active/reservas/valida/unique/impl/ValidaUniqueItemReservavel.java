/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.active.reservas.valida.unique.impl;

import br.com.active.reservas.bean.ItemReservavel;
import br.com.active.reservas.servicos.impl.ServicoItemReservavel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.active.reservas.valida.unique.IValidacaoItemReservavel;
import br.com.active.reservas.valida.unique.IValidacaoUnique;

/**
 *
 * @author Eduardo
 */
@Service
public class ValidaUniqueItemReservavel implements IValidacaoItemReservavel{

    @Autowired
    private ServicoItemReservavel servicoItemReservavel;
    
    @Override
    public boolean validarUnique(Object object) {
        
        ItemReservavel itemReservavel = (ItemReservavel) object;
        boolean s = servicoItemReservavel.buscarPorCodigo(itemReservavel.getCodigo(), itemReservavel.getId());
//        System.out.println(s);
        return s;
        
    }
    
        
}
