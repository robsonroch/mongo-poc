package br.com.robson.apipocmongo.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.robson.apipocmongo.entities.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
	
	Optional<Cliente> findByEmail(String Email);

}
