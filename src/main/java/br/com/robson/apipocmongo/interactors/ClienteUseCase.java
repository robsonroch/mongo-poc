package br.com.robson.apipocmongo.interactors;

import br.com.robson.apipocmongo.entities.Cliente;
import br.com.robson.apipocmongo.transportlayers.openapi.model.ClienteResponse;

public interface ClienteUseCase {
	
	ClienteResponse save(Cliente cliente);

}
