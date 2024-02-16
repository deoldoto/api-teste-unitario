package br.com.apitesteunitario.apitesteunitario.controller.exceptions;

import br.com.apitesteunitario.apitesteunitario.service.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RessosurceExceptionHandlerTest {
    public static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado";
    @InjectMocks
    private RessosurceExceptionHandler exceptionHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void objetoNaoEncontrado() {
        ResponseEntity<ErroPadrao> response = exceptionHandler.objetoNaoEncontrado(
                new ObjectNotFoundException("Objeto não encontrado"),
                new MockHttpServletRequest()
        );

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(ErroPadrao.class, response.getBody().getClass());
        assertEquals(OBJETO_NAO_ENCONTRADO, response.getBody().getErro());
        assertEquals(404, response.getBody().getStatus());

    }

    @Test
    void dataIntegratyuViolationException() {
    }
}