package com.school.web_info.dto;

import com.school.web_info.validation.FullName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(@FullName String fullName, @NotBlank String password,
                      @Email String email, @NotBlank String roles) {
}
