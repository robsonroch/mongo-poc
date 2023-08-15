package br.com.robson.apipocmongo.interactors.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.robson.apipocmongo.entities.Cliente;
import br.com.robson.apipocmongo.interactors.ClienteResponseMapper;
import br.com.robson.apipocmongo.interactors.ClienteUseCase;
import br.com.robson.apipocmongo.interactors.exception.ErroNegocioException;
import br.com.robson.apipocmongo.repositories.ClienteRepository;
import br.com.robson.apipocmongo.transportlayers.openapi.model.ClienteResponse;


@Service
public class ClienteUseCaseImpl implements ClienteUseCase{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public ClienteResponse save(Cliente cliente) {
		
		Optional<Cliente> fromBase = clienteRepository.findByEmail(cliente.getEmail());
		
		if(fromBase.isEmpty()) {
			
			Cliente frombase = clienteRepository.save(cliente);
			
			ClienteResponse response = ClienteResponseMapper.INSTANCE.map(frombase);
			
			return response;
		}
		
		throw new ErroNegocioException("Já existe um usuário com o mesmo email!");
		
	}

	@Override
	public List<ClienteResponse> findAll() {
		List<Cliente> allFromBase = clienteRepository.findAll();
		
		return ClienteResponseMapper.INSTANCE.map(allFromBase);
	}
	

}
