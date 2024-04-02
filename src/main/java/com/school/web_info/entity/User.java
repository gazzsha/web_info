package com.school.web_info.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "lastName"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "birthday", nullable = false)
    private Date birthday;
    @Column(name = "schoolName", nullable = false)
    private String schoolName;
    @Column(name = "skills", nullable = false)
    private String skills;
    @Column(name = "roles", nullable = false)
    private String roles;
}
