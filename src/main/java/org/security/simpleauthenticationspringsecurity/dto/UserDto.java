package org.security.simpleauthenticationspringsecurity.dto;

import lombok.Data;
import org.security.simpleauthenticationspringsecurity.model.Authority;

import java.util.List;


@Data
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private String email;
    private List<Authority> authorityList;


}
