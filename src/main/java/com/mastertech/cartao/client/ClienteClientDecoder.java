package com.mastertech.cartao.client;

import com.mastertech.cartao.exceptions.CartaoNaoEncontradoException;
import com.mastertech.cartao.exceptions.ClienteInvalidoException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ClienteClientDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response){
        if(response.status() == 400){
            throw new ClienteInvalidoException();
        }else {
            return errorDecoder.decode(s, response);
        }
    }
}
