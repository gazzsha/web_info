package com.school.web_info.service;

import com.school.web_info.configuration.UserDetail;
import com.school.web_info.entity.User;
import com.school.web_info.exception.error.InvalidDataUser;
import com.school.web_info.exception.error.NotFoundException;
import com.school.web_info.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.StringTokenizer;

@Service
@NoArgsConstructor
public class MyUserDetailsService implements
        org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        StringTokenizer stringTokenizer = new StringTokenizer(username.trim());
        if (stringTokenizer.countTokens() != 2)
            throw new InvalidDataUser("Логин должен содержать имя и фамилию через пробел");
        User user = userRepository.findUserByNameAndLastName(stringTokenizer.nextToken(), stringTokenizer.nextToken())
                .orElseThrow(() -> new NotFoundException(String.format("Пользователь с логином %s не зарегистрирован.", username)));
        return new UserDetail(user);
    }
}
