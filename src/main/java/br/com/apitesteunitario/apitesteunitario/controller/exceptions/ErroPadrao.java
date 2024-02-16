package br.com.apitesteunitario.apitesteunitario.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
public class ErroPadrao {

    private LocalDateTime timeStamp;
    private Integer status;
    private String erro;
    private String endereco;

}
