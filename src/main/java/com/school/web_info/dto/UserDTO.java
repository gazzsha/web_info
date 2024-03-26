package com.school.web_info.dto;

import com.school.web_info.validation.FullName;

public record UserDTO(@FullName String fullName, String password, String roles) {
}
