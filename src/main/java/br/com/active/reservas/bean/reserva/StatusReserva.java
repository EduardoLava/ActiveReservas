/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.active.reservas.bean.reserva;

/**
 *
 * @author Eduardo
 */
public enum StatusReserva {
    
    ATIVA("Ativa"),
    CANCELADA("Cancelada");

    private final String valor;
    
    private StatusReserva(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    
}
