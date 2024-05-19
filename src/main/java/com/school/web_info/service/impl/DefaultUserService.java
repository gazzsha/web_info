package com.school.web_info.service.impl;

import com.school.web_info.entity.user.User;
import com.school.web_info.repository.UserRepository;
import com.school.web_info.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> getUserByNameAndLastName(String firstName, String lastName) {
        return userRepository.findUserByNameAndLastName(firstName, lastName);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
