package br.com.robson.apipocmongo.transportlayers.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.robson.apipocmongo.entities.Cliente;
import br.com.robson.apipocmongo.transportlayers.openapi.model.ClienteRequest;
import lombok.extern.slf4j.Slf4j;

@Mapper
public interface ClienteRequestMapper {

	ClienteRequestMapper INSTANCE = Mappers.getMapper(ClienteRequestMapper.class);
	
	Cliente map(ClienteRequest request);
	
    default LocalDate mapDate(String value) {
        if (value == null) return null;        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parser = LocalDate.parse(value, formatter);
        return parser;
    }

    default LocalDateTime mapTime(String value) {
        if (value == null) return null;
        return LocalDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    default Boolean map(Integer value) {
        return 1 == value;
    }
}
