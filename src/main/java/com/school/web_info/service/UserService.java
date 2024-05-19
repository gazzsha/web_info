package com.school.web_info.service;

import com.school.web_info.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserByNameAndLastName(String firstName,String lastName);

    List<User> getAllUsers();
}
