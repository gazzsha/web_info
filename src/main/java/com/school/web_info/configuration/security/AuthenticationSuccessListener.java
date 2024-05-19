package com.school.web_info.configuration.security;

import com.school.web_info.configuration.security.UserDetail;
import com.school.web_info.service.impl.TimeActivityService;
import com.school.web_info.utils.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;

@Configuration
@RequiredArgsConstructor
public class AuthenticationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {


    private final TimeActivityService timeActivityService;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        timeActivityService.activityUser((UserDetail) event.getAuthentication().getPrincipal(), Status.Enter);
    }
}
