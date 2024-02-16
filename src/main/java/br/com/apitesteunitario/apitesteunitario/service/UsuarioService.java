package br.com.apitesteunitario.apitesteunitario.service;

import br.com.apitesteunitario.apitesteunitario.dominio.Usuario;
import br.com.apitesteunitario.apitesteunitario.dominio.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {

    Usuario procurarPorID(Integer id);
    List<Usuario> listarTodos();
    Usuario cadastrar(UsuarioDTO usuarioDTO);
    Usuario alterar(UsuarioDTO usuarioDTO);
    void excluir(Integer id);
}
