/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.active.reservas.valida.unique.validator;

import br.com.active.reservas.valida.unique.anottation.ValidarUniqueKey;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import br.com.active.reservas.valida.unique.IValidacaoUnique;

/**
 *
 * @author Eduardo
 * 
 * executa a validação de Unique key em um form
 * 
 */
@Component
public class UniqueValidator implements ConstraintValidator<ValidarUniqueKey, Object> {
    
    private static ApplicationContext applicationContext;

    private IValidacaoUnique service;
    
    @Autowired
    public  void setApplicationContext ( ApplicationContext applicationContext )  { 
        UniqueValidator.applicationContext  = applicationContext ; 
    }
    

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        boolean res = !this.service.validarUnique(o);
        System.out.println(res);
        return res;
    }

    @Override
    public void initialize(ValidarUniqueKey unique) {
        
        Class<? extends IValidacaoUnique> clazz = unique.service();

        this.service = UniqueValidator.applicationContext.getBean(clazz);
        
    }
}
