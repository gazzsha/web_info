package com.school.web_info.controller;


import com.school.web_info.service.impl.TimeActivityService;
import com.school.web_info.utils.Status;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/school")
@RequiredArgsConstructor
public class LogoutController {

    private final SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();


    private final TimeActivityService timeActivityService;

    @GetMapping("/logout")
    public String performLogout(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        this.logoutHandler.logout(request, response, authentication);
        timeActivityService.activityUser(authentication.getPrincipal(), Status.Out);
        return "redirect:/logout";
    }
}
