package com.school.web_info.service;


import com.school.web_info.dto.PeerDTO;
import com.school.web_info.dto.UserDTO;
import com.school.web_info.entity.Peer;
import com.school.web_info.entity.User;
import com.school.web_info.exception.error.NotFoundException;
import com.school.web_info.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.hibernate.JDBCException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;
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
            // TODO : exception of unique
            throw new NotFoundException(exception.getMessage());
        }
    }

    private User convertUserDTOtoUserEntity(UserDTO userDTO) {
        String fullName = userDTO.fullName();
        StringTokenizer stringTokenizer = new StringTokenizer(fullName);
        String name = stringTokenizer.nextToken();
        String lastName = stringTokenizer.nextToken();
        String password = userDTO.password();
        String roles = userDTO.roles();
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(roles);
        return user;
    }

}
