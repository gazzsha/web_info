package com.school.web_info.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users",uniqueConstraints={@UniqueConstraint(columnNames = {"name" , "lastName"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = true)
    private String name;
    @Column(name = "lastName",nullable = true)
    private String lastName;
    @Column(name = "password",nullable = true)
    private String password;
    @Column(name = "roles",nullable = true)
    private String roles;
}
