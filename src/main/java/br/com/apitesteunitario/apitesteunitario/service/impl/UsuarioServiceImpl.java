package br.com.apitesteunitario.apitesteunitario.service.impl;

import br.com.apitesteunitario.apitesteunitario.dominio.Usuario;
import br.com.apitesteunitario.apitesteunitario.repositories.UsuarioRespositorio;
import br.com.apitesteunitario.apitesteunitario.service.UsuarioService;
import br.com.apitesteunitario.apitesteunitario.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private ModelMapper mapper = new ModelMapper();

    @Autowired
    private UsuarioRespositorio usuarioRespositorio;

    @Override
    public Usuario procurarPorID(Integer id) {
        Optional<Usuario> usuario = usuarioRespositorio.findById(id);
        return usuario.orElseThrow(() -> new ObjectNotFoundException("Nenhum registro localizado"));
    }

    public List<Usuario> listarTodos(){
        return usuarioRespositorio.findAll();
    }
}
