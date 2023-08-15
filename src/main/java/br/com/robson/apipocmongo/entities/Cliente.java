package br.com.robson.apipocmongo.entities;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("Cliente")
public class Cliente {
	
    @Id
    private String id;
    private String nome;
    private String sobrenome;
    @Indexed(unique = true)
    private String email;
    private String sexo;
    private LocalDate datanascimento;
    private List<Endereco> enderecos;
    private List<Telefone> telefones;

}
