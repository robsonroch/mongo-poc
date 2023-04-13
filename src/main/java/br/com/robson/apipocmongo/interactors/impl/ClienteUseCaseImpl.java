package br.com.robson.apipocmongo.interactors.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.robson.apipocmongo.entities.Cliente;
import br.com.robson.apipocmongo.interactors.ClienteResponseMapper;
import br.com.robson.apipocmongo.interactors.ClienteUseCase;
import br.com.robson.apipocmongo.repositories.ClienteRepository;
import br.com.robson.apipocmongo.transportlayers.openapi.model.ClienteResponse;


@Service
public class ClienteUseCaseImpl implements ClienteUseCase{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public ClienteResponse save(Cliente cliente) {
		
		Cliente frombase = clienteRepository.save(cliente);
		
		ClienteResponse response = ClienteResponseMapper.INSTANCE.map(frombase);
		
		return response;
	}

}
