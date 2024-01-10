package br.com.apitesteunitario.apitesteunitario.service.impl;

import br.com.apitesteunitario.apitesteunitario.config.ModelMapperConfig;
import br.com.apitesteunitario.apitesteunitario.dominio.Usuario;
import br.com.apitesteunitario.apitesteunitario.dominio.dto.UsuarioDTO;
import br.com.apitesteunitario.apitesteunitario.repositories.UsuarioRespositorio;
import br.com.apitesteunitario.apitesteunitario.service.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class UsuarioServiceImplTest {

    public static final Integer ID = 1;
    public static final String NOME = "Tiago";
    public static final String EMAIL = "deoldoto@gmail.com";
    public static final String SENHA = "123";
    @InjectMocks
    private UsuarioServiceImpl service;
    @Mock
    private UsuarioRespositorio repositorio;
    @Mock
    private ModelMapperConfig mapper;

    private Usuario usuario;
    private UsuarioDTO usuarioDTO;
    private Optional<Usuario> optionalUsuario;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        inicializaUsuario();
    }

    @Test
    void procurarPorID() {
        when(repositorio.findById(anyInt())).thenReturn(optionalUsuario);

        Usuario retorno = service.procurarPorID(ID);

        assertNotNull(retorno);
        assertEquals(Usuario.class, retorno.getClass());
        assertEquals(ID,retorno.getId());
        assertEquals(NOME,retorno.getNome());
        assertEquals(EMAIL,retorno.getEmail());
    }
    @Test
    void wenFindByIdThenReturnAnObjectNotFoundException(){
        when(repositorio.findById(anyInt())).thenThrow(new ObjectNotFoundException("Objeto não encontrado"));

        try{
            service.procurarPorID(1);
        } catch(Exception e){
            assertEquals(ObjectNotFoundException.class, e.getClass());
            assertEquals("Objeto não encontrado", e.getMessage());
        }
    }
    @Test
    void listarTodos() {
    }

    @Test
    void cadastrar() {
    }

    @Test
    void alterar() {
    }

    @Test
    void excluir() {
    }

    private void inicializaUsuario(){
        usuario = new Usuario(ID, NOME, EMAIL, SENHA);
        usuarioDTO = new UsuarioDTO(ID, NOME, EMAIL, SENHA);
        optionalUsuario = Optional.of(new Usuario(ID, NOME, EMAIL, SENHA));

    }
}