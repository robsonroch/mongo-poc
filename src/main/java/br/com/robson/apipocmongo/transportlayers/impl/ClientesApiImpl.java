package br.com.robson.apipocmongo.transportlayers.impl;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import br.com.robson.apipocmongo.entities.Cliente;
import br.com.robson.apipocmongo.interactors.ClienteUseCase;
import br.com.robson.apipocmongo.transportlayers.openapi.api.ClientesApi;
import br.com.robson.apipocmongo.transportlayers.openapi.model.ClienteRequest;
import br.com.robson.apipocmongo.transportlayers.openapi.model.ClienteResponse;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping
@Slf4j
public class ClientesApiImpl implements ClientesApi{
	
	@Autowired
	private ClienteUseCase clienteUseCase;
	
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ClientesApiImpl.class);
	
	private static Integer count = 0;
		
	public ResponseEntity<ClienteResponse> clientesPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ClienteRequest clienteRequest){
		
		Cliente toSave = ClienteRequestMapper.INSTANCE.map(clienteRequest);
		
		toSave.setId(null);
		return ResponseEntity.ok(clienteUseCase.save(toSave));
		
	}
	
	public ResponseEntity<List<ClienteResponse>> clientesGet(){

		List<ClienteResponse> clientes = clienteUseCase.findAll();
		
		ObjectMapper objectMapper = new ObjectMapper();

        // Configurar o ObjectMapper para gerar JSON formatado
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		String jsonStringClientes ="";
		try {
			
			jsonStringClientes = objectMapper.writeValueAsString(clientes);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MDC.put("jsonStringClientes", jsonStringClientes);
		log.info("clientes ID:" + jsonStringClientes);

		return ResponseEntity.ok(clienteUseCase.findAll());
		
    }

}
