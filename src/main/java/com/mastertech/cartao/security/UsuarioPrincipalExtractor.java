package com.mastertech.cartao.security;

import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;

import java.util.Map;

public class UsuarioPrincipalExtractor  implements PrincipalExtractor {

    @Override
    public Object extractPrincipal(Map<String, Object> map) {
        Usuario usuario = new Usuario();

        usuario.setNome(map.get("name").toString());
        usuario.setId((Integer) map.get("id"));

        return usuario;
    }

}
