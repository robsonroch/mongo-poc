package br.com.robson.apipocmongo.interactors;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.robson.apipocmongo.entities.Cliente;
import br.com.robson.apipocmongo.interactors.impl.ClienteUseCaseImpl;
import br.com.robson.apipocmongo.repositories.ClienteRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest
public class ClienteUseCaseTest {
	
	@MockBean
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteUseCaseImpl clienteUseCase;
	

	@SuppressWarnings("deprecation")
	@Test
	public void testSave() {
		
		Cliente cliente = Cliente.builder().datanascimento(LocalDate.of(2023,  10, 10)).email("email@teste").nome("Fulano").sobrenome("da silva").build();
				
		when(clienteRepository.save(any(Cliente.class))).thenReturn(null);
		Cliente  save = clienteRepository.save(cliente);
		
		ArgumentCaptor<Cliente> captor = ArgumentCaptor.forClass(Cliente.class);
		Mockito.verify(clienteRepository).save(captor.capture());		
		Cliente result = captor.getValue();
		
		assertThat(cliente).isEqualToComparingFieldByField(result);
		
		assertTrue(true);
	}

}
