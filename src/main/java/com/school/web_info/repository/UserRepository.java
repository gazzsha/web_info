package com.school.web_info.repository;

import com.school.web_info.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByNameAndLastName(String name, String lastName);
}
