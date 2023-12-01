package br.com.apitesteunitario.apitesteunitario.controller;

import br.com.apitesteunitario.apitesteunitario.dominio.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class usuarioController {
    @GetMapping(value="/{id}")
    public ResponseEntity<Usuario> buscaPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(new Usuario(1, "Tiago", "deoldoto@gmail.com", "123"));
    }
}
