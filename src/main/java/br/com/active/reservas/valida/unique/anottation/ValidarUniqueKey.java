/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.active.reservas.valida.unique.anottation;

import br.com.active.reservas.valida.unique.validator.UniqueValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import br.com.active.reservas.valida.unique.IValidacaoUnique;

/**
 *
 * @author Eduardo
 */
@Target({ElementType.TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueValidator.class)
public @interface ValidarUniqueKey {
    
    String message() default "Valor Inválido";
    Class<? extends IValidacaoUnique> service();
    String serviceQualifier() default "";
    
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
}
