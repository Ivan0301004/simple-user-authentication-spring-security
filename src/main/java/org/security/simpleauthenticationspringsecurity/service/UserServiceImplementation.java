package org.security.simpleauthenticationspringsecurity.service;

import lombok.AllArgsConstructor;
import org.security.simpleauthenticationspringsecurity.config.PasswordEncoderService;
import org.security.simpleauthenticationspringsecurity.exceptions.UsernameAlreadyTaken;
import org.security.simpleauthenticationspringsecurity.model.User;
import org.security.simpleauthenticationspringsecurity.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoderService passwordEncoder;

    @Override
    @Transactional
    public User saveUser(User user) {
        return Optional.of(user).filter(ent -> !userRepository.existsByUsername(user.getUsername()))
                .map(user1 -> {
                    User createUser = User.builder()
                            .username(user.getUsername())
                            .password(passwordEncoder.passwordEncoder().encode(user.getPassword()))
                            .email(user.getEmail())
                            .build();
                    return this.userRepository.save(createUser);
                })
                .orElseThrow(() -> new UsernameAlreadyTaken("Username already taken!", HttpStatus.BAD_REQUEST));
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }
}
