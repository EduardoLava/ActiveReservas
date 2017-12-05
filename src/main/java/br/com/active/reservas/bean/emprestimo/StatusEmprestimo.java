/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.active.reservas.bean.emprestimo;

/**
 *
 * @author syena
 */
public enum StatusEmprestimo {
    
    ATIVO("Ativo"),
    CANCELADO("Cancelado");
    
    private String value;
    
    
    private StatusEmprestimo(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
}
