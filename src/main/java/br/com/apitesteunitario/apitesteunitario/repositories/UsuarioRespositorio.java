package br.com.apitesteunitario.apitesteunitario.repositories;

import br.com.apitesteunitario.apitesteunitario.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRespositorio extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
}
