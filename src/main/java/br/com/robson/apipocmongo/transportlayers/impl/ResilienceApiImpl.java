package br.com.robson.apipocmongo.transportlayers.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.robson.apipocmongo.transportlayers.openapi.api.ApiUtil;
import br.com.robson.apipocmongo.transportlayers.openapi.api.ResilienciaApi;
import br.com.robson.apipocmongo.transportlayers.openapi.model.ClienteResponse;
import br.com.robson.apipocmongo.transportlayers.openapi.model.GenericResponse;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping
@Slf4j
public class ResilienceApiImpl implements ResilienciaApi {
	
	private static Integer count = 0;

    public ResponseEntity<GenericResponse> getTestErroByStatus(@PathVariable("statusCodeErro") Integer statusCodeErro) {

    	log.info("teste erro para o estatus {}", statusCodeErro );
    	
    	return ResponseEntity.status(HttpStatus.valueOf(statusCodeErro)).build();
    	
    }

    public ResponseEntity<GenericResponse> getTestRetry(@PathVariable("attempts") Integer attempts) {
    	
		if(count < attempts) {
			count ++;
			System.out.println("Deum ruim: " + count);
			return ResponseEntity.internalServerError().build();
		}else {
			System.out.println("Deum bom: " + count);
			count = 0;
			GenericResponse response = new GenericResponse();
			response.description("Enfim a responta sem erro");
			
			return ResponseEntity.ok(response);
		}

    }

}
