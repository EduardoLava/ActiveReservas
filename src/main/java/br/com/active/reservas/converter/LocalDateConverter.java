/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.active.reservas.converter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
/**
 *
 * @author Eduardo
 * 
 * para converter as datas no momento da conversão
 * 
 */
@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDateTime, Timestamp>{

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime localDate) {
        return Timestamp.valueOf(localDate);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp date) {
        return date.toLocalDateTime();
    }
    
}
