package org.security.simpleauthenticationspringsecurity.security.user;

import org.security.simpleauthenticationspringsecurity.model.Authority;
import org.springframework.security.core.GrantedAuthority;

public record SecureAuthority(Authority authority) implements GrantedAuthority {

    @Override
    public String getAuthority() {
        return authority.getName();
    }
}
