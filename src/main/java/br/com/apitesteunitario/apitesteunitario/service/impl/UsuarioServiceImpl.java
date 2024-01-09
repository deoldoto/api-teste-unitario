package br.com.apitesteunitario.apitesteunitario.service.impl;

import br.com.apitesteunitario.apitesteunitario.dominio.Usuario;
import br.com.apitesteunitario.apitesteunitario.dominio.dto.UsuarioDTO;
import br.com.apitesteunitario.apitesteunitario.repositories.UsuarioRespositorio;
import br.com.apitesteunitario.apitesteunitario.service.UsuarioService;
import br.com.apitesteunitario.apitesteunitario.service.exceptions.DataIntegratyViolationException;
import br.com.apitesteunitario.apitesteunitario.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

//    private ModelMapper mapper = new ModelMapper();

    @Autowired
    private UsuarioRespositorio usuarioRespositorio;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Usuario procurarPorID(Integer id) {
        Optional<Usuario> usuario = usuarioRespositorio.findById(id);
        return usuario.orElseThrow(() -> new ObjectNotFoundException("Nenhum registro localizado"));
    }
    public List<Usuario> listarTodos(){
        return usuarioRespositorio.findAll();
    }

    @Override
    public Usuario cadastrar(UsuarioDTO usuarioDTO) {
        procurarPorEmail(usuarioDTO);
        return usuarioRespositorio.save(mapper.map(usuarioDTO, Usuario.class));
    }

    @Override
    public Usuario alterar(UsuarioDTO usuarioDTO) {
        procurarPorEmail(usuarioDTO);
        return usuarioRespositorio.save(mapper.map(usuarioDTO, Usuario.class));
    }

    @Override
    public void excluir(Integer id) {
        procurarPorID(id);
        usuarioRespositorio.deleteById(id);
    }

    private void procurarPorEmail(UsuarioDTO usuarioDTO){
        Optional<Usuario> usuario = usuarioRespositorio.findByEmail(usuarioDTO.getEmail());
        if(usuario.isPresent() && !usuario.get().getId().equals(usuarioDTO.getId())){
            throw new DataIntegratyViolationException("E-Mail já cadastrado no sistema.");
        }
    }
}
