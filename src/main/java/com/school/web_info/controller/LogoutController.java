package com.school.web_info.controller;


import com.school.web_info.service.TimeActivityService;
import com.school.web_info.utils.Status;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/school")
@Slf4j
@RequiredArgsConstructor
public class LogoutController {

    private final TimeActivityService timeActivityService;

    @GetMapping("/logout")
    public String performLogout(HttpServletRequest httpServletRequest) {
        timeActivityService.activityUser((UserDetails) (((Authentication)httpServletRequest.getUserPrincipal()).getPrincipal()), Status.Out);
        return "redirect:/logout";
    }
}
