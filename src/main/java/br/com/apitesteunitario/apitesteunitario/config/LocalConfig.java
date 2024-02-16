package br.com.apitesteunitario.apitesteunitario.config;

import br.com.apitesteunitario.apitesteunitario.dominio.Usuario;
import br.com.apitesteunitario.apitesteunitario.repositories.UsuarioRespositorio;
import br.com.apitesteunitario.apitesteunitario.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UsuarioRespositorio usuarioRespositorio;

    @Bean
    Bean startDB(){
        Usuario usuario1 = new Usuario(null, "Tiago", "deoldoto@gmail.com", "123");
        Usuario usuario2 = new Usuario(null, "Kauã", "kaua@gmail.com", "123");
        usuarioRespositorio.saveAll(List.of(usuario1, usuario2));

        return null;
    }
}
