package org.security.simpleauthenticationspringsecurity.service;


import org.security.simpleauthenticationspringsecurity.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();
}
