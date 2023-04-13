package br.com.robson.apipocmongo.entities;

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
public class Endereco {
	
    private String logradouro;
    private String estado;
    private String municipio;
    private String bairro;
    private String cep;
    private String complemento;

}
