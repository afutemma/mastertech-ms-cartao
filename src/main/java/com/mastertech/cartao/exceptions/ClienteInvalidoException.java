package com.mastertech.cartao.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "O cliente informado não existe ou não é valido")
public class ClienteInvalidoException extends RuntimeException {
}
