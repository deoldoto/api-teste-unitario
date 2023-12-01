package br.com.apitesteunitario.apitesteunitario.repositories;

import br.com.apitesteunitario.apitesteunitario.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRespositorio extends JpaRepository<Usuario, Integer> {
}
