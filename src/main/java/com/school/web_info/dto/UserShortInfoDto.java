package com.school.web_info.dto;

import java.time.LocalDate;

public record UserShortInfoDto(String name, String lastName,
                               String email, LocalDate birthday,
                               String school,String skills) {
}
