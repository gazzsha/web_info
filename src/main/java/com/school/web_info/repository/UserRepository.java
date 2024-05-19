package com.school.web_info.repository;

import com.school.web_info.entity.user.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByNameAndLastName(String name, String lastName);
    List<User> findAllByRoles(String role);

    @NotNull
    List<User> findAll();
}
