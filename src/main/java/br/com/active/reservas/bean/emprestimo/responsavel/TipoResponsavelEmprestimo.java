/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.active.reservas.bean.emprestimo.responsavel;

import lombok.Getter;

/**
 *
 * @author syena
 */
public enum TipoResponsavelEmprestimo {
    
    RESPONSAVEL("Responsavel"),
    FUNCIONARIO("Funcionario");
    
    @Getter
    private String value;
    
    private TipoResponsavelEmprestimo(String value){
        this.value = value;
    }
    
}
