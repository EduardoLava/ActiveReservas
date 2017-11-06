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
public enum StatusAtivo {
    
    DISPONIVEL("Disponível"),
    INDISPONIVEL("Indisponível"),
    MANUTENCAO("Manutenção"),
    INATIVO("Inativo");
    
    private final String valor;
    
    private StatusAtivo(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    
}
