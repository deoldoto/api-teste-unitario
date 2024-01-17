package br.com.apitesteunitario.apitesteunitario.service.impl;

import br.com.apitesteunitario.apitesteunitario.config.ModelMapperConfig;
import br.com.apitesteunitario.apitesteunitario.dominio.Usuario;
import br.com.apitesteunitario.apitesteunitario.dominio.dto.UsuarioDTO;
import br.com.apitesteunitario.apitesteunitario.repositories.UsuarioRespositorio;
import br.com.apitesteunitario.apitesteunitario.service.exceptions.DataIntegratyViolationException;
import br.com.apitesteunitario.apitesteunitario.service.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UsuarioServiceImplTest {

    public static final Integer ID = 1;
    public static final String NOME = "Tiago";
    public static final String EMAIL = "deoldoto@gmail.com";
    public static final String SENHA = "123";
    public static final int INDEX = 0;
    public static final String E_MAIL_JA_CADASTRADO_NO_SISTEMA = "E-Mail já cadastrado no sistema.";
    @InjectMocks
    private UsuarioServiceImpl service;
    @Mock
    private UsuarioRespositorio repositorio;
    @Mock
    private ModelMapper mapper;

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
    void whenFindByIdThenReturnAnObjectNotFoundException(){
        when(repositorio.findById(anyInt())).thenThrow(new ObjectNotFoundException("Objeto não encontrado"));

        try{
            service.procurarPorID(1);
        } catch(Exception e){
            assertEquals(ObjectNotFoundException.class, e.getClass());
            assertEquals("Objeto não encontrado", e.getMessage());
        }
    }
    @Test
    void listarTodosTest() {
        when(repositorio.findAll()).thenReturn(List.of(usuario));
        List<Usuario> retorno = repositorio.findAll();

        assertNotNull(retorno);
        assertEquals(1,retorno.size());
        assertEquals(Usuario.class, retorno.get(INDEX).getClass());

        assertEquals(ID, retorno.get(INDEX).getId());
        assertEquals(NOME, retorno.get(INDEX).getNome());
        assertEquals(EMAIL, retorno.get(INDEX).getEmail());
        assertEquals(SENHA, retorno.get(INDEX).getSenha());
    }

    @Test
    void cadastrarComSucesso() {
        when(repositorio.save(any())).thenReturn(usuario);
        Usuario retorno = service.cadastrar(usuarioDTO);

        assertNotNull(retorno);
        assertEquals(Usuario.class, retorno.getClass());
        assertEquals(ID, retorno.getId());
        assertEquals(NOME, retorno.getNome());
        assertEquals(EMAIL, retorno.getEmail());
        assertEquals(SENHA, retorno.getSenha());


    }

    @Test
    void cadastrarComFalhaDeIntegridadeDeDados() {
        when(repositorio.findByEmail(anyString())).thenReturn(optionalUsuario);
        try{
            optionalUsuario.get().setId(2);
            service.cadastrar(usuarioDTO);
        }catch(Exception e){
            assertEquals(DataIntegratyViolationException.class, e.getClass());
            assertEquals(E_MAIL_JA_CADASTRADO_NO_SISTEMA, e.getMessage());
        }
    }

    @Test
    void alterarComSucesso() {
        when(repositorio.save(any())).thenReturn(usuario);
        Usuario retorno = service.alterar(usuarioDTO);

        assertNotNull(retorno);
        assertEquals(Usuario.class, retorno.getClass());
        assertEquals(ID, retorno.getId());
        assertEquals(NOME, retorno.getNome());
        assertEquals(EMAIL, retorno.getEmail());
        assertEquals(SENHA, retorno.getSenha());
    }

    @Test
    void alterarComFalhaDeIntegridadeDeDados() {
        when(repositorio.findByEmail(anyString())).thenReturn(optionalUsuario);
        try{
            optionalUsuario.get().setId(2);
            service.alterar(usuarioDTO);
        }catch(Exception e){
            assertEquals(DataIntegratyViolationException.class, e.getClass());
            assertEquals(E_MAIL_JA_CADASTRADO_NO_SISTEMA, e.getMessage());
        }
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