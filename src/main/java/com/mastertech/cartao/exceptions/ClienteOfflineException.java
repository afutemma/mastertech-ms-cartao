package com.mastertech.cartao.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_GATEWAY, reason = "O sistema de cliente se encontra offline")
public class ClienteOfflineException extends RuntimeException{
}
