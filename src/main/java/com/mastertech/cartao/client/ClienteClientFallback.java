package com.mastertech.cartao.client;

import com.mastertech.cartao.exceptions.ClienteOfflineException;
import com.mastertech.cartao.model.Cliente;

public class ClienteClientFallback implements ClienteClient {


    @Override
    public Cliente getClientePorId(String id) {
        throw new ClienteOfflineException();

    }
}
