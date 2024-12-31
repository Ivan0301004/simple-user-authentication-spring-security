package org.security.simpleauthenticationspringsecurity.security.authentication;

import org.security.simpleauthenticationspringsecurity.repository.UserRepository;
import org.security.simpleauthenticationspringsecurity.security.user.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userAuth = this.userRepository.findUserByUsername(username);
        return userAuth.map(CustomUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Not found!"));
    }
}
