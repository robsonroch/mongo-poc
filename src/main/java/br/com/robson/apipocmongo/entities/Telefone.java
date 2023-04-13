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
public class Telefone {
	
    private String ddd;
    private String numero;
    private String tipo;
    private boolean principal;

}
