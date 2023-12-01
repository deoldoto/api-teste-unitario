package br.com.apitesteunitario.apitesteunitario.controller;

import br.com.apitesteunitario.apitesteunitario.dominio.Usuario;
import br.com.apitesteunitario.apitesteunitario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class usuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping(value="/{id}")
    public ResponseEntity<Usuario> buscaPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(usuarioService.procurarPorID(id));
    }
}
