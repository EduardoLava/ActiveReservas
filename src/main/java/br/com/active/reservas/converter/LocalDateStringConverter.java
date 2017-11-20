/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.active.reservas.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Eduardo
 */
public class LocalDateStringConverter {
    
    public static LocalDate parse(String data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, formatter);
    }
    
}
