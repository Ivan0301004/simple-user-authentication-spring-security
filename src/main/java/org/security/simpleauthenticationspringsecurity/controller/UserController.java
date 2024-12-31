package org.security.simpleauthenticationspringsecurity.controller;

import lombok.AllArgsConstructor;
import org.security.simpleauthenticationspringsecurity.dto.Message;
import org.security.simpleauthenticationspringsecurity.dto.UserDto;
import org.security.simpleauthenticationspringsecurity.dto.UserRequest;
import org.security.simpleauthenticationspringsecurity.mapper.UserMapper;
import org.security.simpleauthenticationspringsecurity.model.User;
import org.security.simpleauthenticationspringsecurity.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/users")
@AllArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/save")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserRequest userRequest) {
        User user = this.userService.saveUser((User) this.userMapper.toEntity(userRequest));
        UserDto userDto = this.userMapper.toDto(user);
        URI location = URI.create("/api/users/" + userDto.getId());
        return ResponseEntity.created(location).body(userDto);
    }


    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(this.userService.getAllUsers());
    }

    @GetMapping("/hello")
    public Message hello() {
        Authentication user = SecurityContextHolder.getContext().getAuthentication();
        return new Message("Welcome back " + user.getName() + "!!");
    }

    @GetMapping("/bye")
    public String bye() {
        return "Bye i want to work to the US";
    }
}
