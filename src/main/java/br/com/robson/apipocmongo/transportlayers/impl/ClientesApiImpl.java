package br.com.robson.apipocmongo.transportlayers.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.robson.apipocmongo.entities.Cliente;
import br.com.robson.apipocmongo.interactors.ClienteUseCase;
import br.com.robson.apipocmongo.repositories.ClienteRepository;
import br.com.robson.apipocmongo.transportlayers.openapi.api.ClientesApi;
import br.com.robson.apipocmongo.transportlayers.openapi.model.ClienteRequest;
import br.com.robson.apipocmongo.transportlayers.openapi.model.ClienteResponse;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping
@NoArgsConstructor
@AllArgsConstructor
public class ClientesApiImpl implements ClientesApi{
	
	@Autowired
	private ClienteUseCase clienteUseCase;
		
	public ResponseEntity<ClienteResponse> clientesPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ClienteRequest clienteRequest){
		
		Cliente toSave = ClienteRequestMapper.INSTANCE.map(clienteRequest);
		
		return ResponseEntity.ok(clienteUseCase.save(toSave));
		
	}

}
