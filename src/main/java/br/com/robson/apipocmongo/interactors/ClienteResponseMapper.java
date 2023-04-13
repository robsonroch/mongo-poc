package br.com.robson.apipocmongo.interactors;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.robson.apipocmongo.entities.Cliente;
import br.com.robson.apipocmongo.transportlayers.openapi.model.ClienteResponse;

@Mapper
public interface ClienteResponseMapper {
	
	ClienteResponseMapper INSTANCE = Mappers.getMapper(ClienteResponseMapper.class);
	
	ClienteResponse map(Cliente entity);
	
    default LocalDate mapDate(String value) {
        if (value == null) return null;
        return LocalDate.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    default LocalDateTime mapTime(String value) {
        if (value == null) return null;
        return LocalDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    default Boolean map(Integer value) {
        return 1 == value;
    }

}
