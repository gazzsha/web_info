package com.school.web_info.controller;


import com.school.web_info.dto.user.UserDTO;
import com.school.web_info.entity.user.User;
import com.school.web_info.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/school")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;

    @GetMapping(value = "/login", produces = MediaType.TEXT_HTML_VALUE)
    public String login() {
        return "auth/login-page";
    }

    @GetMapping(value = "/auth", produces = MediaType.TEXT_HTML_VALUE)
    public String mainWindow() {
        return "auth/auth-main-view";
    }

    @PostMapping(value = "/auth/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> authUser(@RequestBody @Valid UserDTO userDTO) {
        User user = authService.addUser(userDTO);
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/main", produces = MediaType.TEXT_HTML_VALUE)
    public String mainPage() {
        return "index";
    }
}
