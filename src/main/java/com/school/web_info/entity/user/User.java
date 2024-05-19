package com.school.web_info.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

@Data
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "lastName"})})
@FilterDefs({
        @FilterDef(
                name = "nameFilter",
                parameters = @ParamDef(name = "nameUser", type = String.class)),
        @FilterDef(
                name = "lastNameFilter",
                parameters = @ParamDef(name = "lastNameUser", type = String.class)),
}
)
@Filters({
        @Filter(
                name = "nameFilter",
                condition = "name = :nameUser"),
        @Filter(
                name = "lastNameFilter",
                condition = "lastName =:lastNameUser"
        )}
)
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
    @Column(name = "roles", nullable = false)
    private String roles;
}
