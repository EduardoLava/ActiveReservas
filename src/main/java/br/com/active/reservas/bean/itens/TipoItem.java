/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.active.reservas.bean.itens;

/**
 *
 * @author Eduardo
 */
public enum TipoItem {
    
    ATIVO("Equipamento"),
    SALA("Sala");
    
    private final String value;
    
    private TipoItem(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
}
