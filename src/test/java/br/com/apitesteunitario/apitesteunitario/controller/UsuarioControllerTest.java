package br.com.apitesteunitario.apitesteunitario.controller;

import br.com.apitesteunitario.apitesteunitario.dominio.Usuario;
import br.com.apitesteunitario.apitesteunitario.dominio.dto.UsuarioDTO;
import br.com.apitesteunitario.apitesteunitario.service.impl.UsuarioServiceImpl;
import org.apache.coyote.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

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
    private UsuarioController controller;
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
        when(usuarioService.procurarPorID(anyInt())).thenReturn(usuario);
        when(mapper.map(any(), any())).thenReturn(usuarioDTO);

        ResponseEntity<UsuarioDTO> response = controller.buscaPorId(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(UsuarioDTO.class, response.getBody().getClass());

        assertEquals(ID, response.getBody().getId());
        assertEquals(NOME, response.getBody().getNome());
        assertEquals(EMAIL, response.getBody().getEmail());
        assertEquals(SENHA, response.getBody().getSenha());
    }

    @Test
    void listarTodos() {
        when(usuarioService.listarTodos()).thenReturn(List.of(usuario));
        when(mapper.map(any(), any())).thenReturn(usuarioDTO);

        ResponseEntity<List<UsuarioDTO>> response = controller.listarTodos();

        assertNotNull(response);
        assertNotNull(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
//        assertEquals(ArrayList.class, response.getBody().getClass());
        assertEquals(UsuarioDTO.class, response.getBody().get(INDEX).getClass());

        assertEquals(ID, response.getBody().get(INDEX).getId());
        assertEquals(NOME, response.getBody().get(INDEX).getNome());
        assertEquals(EMAIL, response.getBody().get(INDEX).getEmail());
        assertEquals(SENHA, response.getBody().get(INDEX).getSenha());

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

    private void inicializaUsuario() {
        usuario = new Usuario(ID, NOME, EMAIL, SENHA);
        usuarioDTO = new UsuarioDTO(ID, NOME, EMAIL, SENHA);
    }
}