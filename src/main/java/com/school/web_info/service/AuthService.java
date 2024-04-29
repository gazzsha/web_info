package com.school.web_info.service;


import com.school.web_info.dto.UserDTO;
import com.school.web_info.entity.User;
import com.school.web_info.exception.error.DataBaseException;
import com.school.web_info.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.hibernate.JDBCException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.StringTokenizer;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public User addUser(UserDTO userDTO) {
        try {
            User user = convertUserDTOtoUserEntity(userDTO);
            return userRepository.saveAndFlush(user);
        } catch (JDBCException exception) {
            throw new DataBaseException(exception.getMessage());
        }
    }

    private User convertUserDTOtoUserEntity(UserDTO userDTO) {
        String fullName = userDTO.fullName();
        StringTokenizer stringTokenizer = new StringTokenizer(fullName);
        User user = new User();
        user.setName(stringTokenizer.nextToken());
        user.setLastName(stringTokenizer.nextToken());
        user.setPassword(passwordEncoder.encode(userDTO.password()));
        user.setEmail(userDTO.email());
        user.setRoles(userDTO.roles());
        return user;
    }

}
