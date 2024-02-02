package br.com.apitesteunitario.apitesteunitario.controller;

import br.com.apitesteunitario.apitesteunitario.dominio.Usuario;
import br.com.apitesteunitario.apitesteunitario.dominio.dto.UsuarioDTO;
import br.com.apitesteunitario.apitesteunitario.service.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsuarioControllerTest {
    public static final Integer ID = 1;
    public static final String NOME = "Tiago";
    public static final String EMAIL = "deoldoto@gmail.com";
    public static final String SENHA = "123";
    public static final int INDEX = 0;
    public static final String E_MAIL_JA_CADASTRADO_NO_SISTEMA = "E-Mail já cadastrado no sistema.";
    public static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado.";

    private Usuario usuario;
    private UsuarioDTO usuarioDTO;

    @InjectMocks
    private  UsuarioController controller;
    @Mock
    private UsuarioServiceImpl usuarioService;
    @Mock
    private ModelMapper mapper;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        inicializaUsuario();
    }

    @Test
    void buscaPorId() {
    }

    @Test
    void listarTodos() {
    }

    @Test
    void incluir() {
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
    }
}