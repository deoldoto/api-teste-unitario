package br.com.apitesteunitario.apitesteunitario.service;

import br.com.apitesteunitario.apitesteunitario.dominio.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario procurarPorID(Integer id);
    List<Usuario> listarTodos();
}
