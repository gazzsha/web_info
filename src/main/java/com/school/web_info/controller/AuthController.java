package com.school.web_info.controller;


import com.school.web_info.dto.UserDTO;
import com.school.web_info.entity.User;
import com.school.web_info.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/school")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;


    @PostMapping("/auth")
    public ResponseEntity<User> authUser(@RequestBody @Valid  UserDTO userDTO) {
        User user = authService.addUser(userDTO);
        return ResponseEntity.ok(user);
    }
}
