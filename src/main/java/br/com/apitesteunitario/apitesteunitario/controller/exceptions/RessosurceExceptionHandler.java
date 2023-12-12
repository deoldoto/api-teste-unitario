package br.com.apitesteunitario.apitesteunitario.controller.exceptions;

import br.com.apitesteunitario.apitesteunitario.service.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RessosurceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ErroPadrao>objetoNaoEncontrado(ObjectNotFoundException exception, HttpServletRequest request){

    }
}
