package com.pucpr.backend.model.DTO;

import org.springframework.security.core.GrantedAuthority;

public class UserAuthorityDTO implements GrantedAuthority {
    private String authority;

    public UserAuthorityDTO(String authority){
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}