package br.com.robson.apipocmongo.interactors;

import java.util.List;

import br.com.robson.apipocmongo.entities.Cliente;
import br.com.robson.apipocmongo.transportlayers.openapi.model.ClienteResponse;

public interface ClienteUseCase {
	
	ClienteResponse save(Cliente cliente);
	
	List<ClienteResponse> findAll();

}
