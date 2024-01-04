package br.com.apitesteunitario.apitesteunitario.controller;

import br.com.apitesteunitario.apitesteunitario.dominio.Usuario;
import br.com.apitesteunitario.apitesteunitario.dominio.dto.UsuarioDTO;
import br.com.apitesteunitario.apitesteunitario.service.UsuarioService;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ModelMapper mapper;
    @GetMapping(value="/{id}")
    public ResponseEntity<UsuarioDTO> buscaPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(mapper.map(usuarioService.procurarPorID(id), UsuarioDTO.class));
    }

    @GetMapping()
    public ResponseEntity<List<UsuarioDTO>> lsitarTodos(){
        List<UsuarioDTO> listaUsuariosDTO = usuarioService.listarTodos().stream().map(usuario -> mapper.map(usuario, UsuarioDTO.class)).toList();
        return ResponseEntity.ok().body(listaUsuariosDTO);
    }
}
