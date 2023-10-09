package br.com.robson.apipocmongo.transportlayers.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.robson.apipocmongo.config.OnboardingProperties;
import br.com.robson.apipocmongo.entities.Cliente;
import br.com.robson.apipocmongo.entities.Sistema;
import br.com.robson.apipocmongo.interactors.ClienteUseCase;
import br.com.robson.apipocmongo.transportlayers.openapi.api.ClientesApi;
import br.com.robson.apipocmongo.transportlayers.openapi.model.ClienteRequest;
import br.com.robson.apipocmongo.transportlayers.openapi.model.ClienteResponse;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping
public class ClientesApiImpl implements ClientesApi{
	
	@Autowired
	private ClienteUseCase clienteUseCase;
	
	@Autowired
	private OnboardingProperties sistemas;
	
	private static Integer count = 0;
		
	public ResponseEntity<ClienteResponse> clientesPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ClienteRequest clienteRequest){
		
		Cliente toSave = ClienteRequestMapper.INSTANCE.map(clienteRequest);
		
		toSave.setId(null);
		return ResponseEntity.ok(clienteUseCase.save(toSave));
		
	}
	
	public ResponseEntity<List<ClienteResponse>> clientesGet() {
		List<Sistema> sistema = sistemas.getSistema();

		if(count < 7) {
			count ++;
			System.out.println("Deum ruim: " + count);
			return ResponseEntity.internalServerError().build();
		}else {
			System.out.println("Deum bom: " + count);
			count = 0;
			List<ClienteResponse> findAll = clienteUseCase.findAll();
			return ResponseEntity.ok(findAll);
		}
		
    }

}
