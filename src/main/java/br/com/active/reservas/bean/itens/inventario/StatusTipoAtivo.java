/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.active.reservas.bean.itens.inventario;

/**
 *
 * @author Eduardo
 */
public enum StatusTipoAtivo {
    
    ATIVO("Ativo"),
    INATIVO("Inativo");
    
    private final String valor;
    
    private StatusTipoAtivo(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    
}
