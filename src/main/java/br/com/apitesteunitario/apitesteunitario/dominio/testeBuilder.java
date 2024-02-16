package br.com.apitesteunitario.apitesteunitario.dominio;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter@Setter
public class testeBuilder {
    private String nome;
    private Integer id;
    private String email;
    private Integer idade;
}
