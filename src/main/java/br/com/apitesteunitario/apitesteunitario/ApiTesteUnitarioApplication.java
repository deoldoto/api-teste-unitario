package br.com.apitesteunitario.apitesteunitario;

import br.com.apitesteunitario.apitesteunitario.dominio.testeBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiTesteUnitarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiTesteUnitarioApplication.class, args);
        testeBuilder teste = testeBuilder.builder().nome("Tiago").email("deoldoto@gmail.com").build();
        System.out.println("Nome: "+ teste.getNome());
        System.out.println("Email: " +teste.getEmail());
    }

}
