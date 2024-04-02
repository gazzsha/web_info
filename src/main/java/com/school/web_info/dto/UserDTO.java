package com.school.web_info.dto;

import com.school.web_info.validation.FullName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public record UserDTO(@FullName String fullName, @NotBlank String password,
                      @Email String email, @NotNull Date birthday,
                      @NotBlank String schoolName, @NotBlank String skills, @NotBlank String roles) {
}
