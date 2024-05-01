package com.school.web_info.dto.questioner;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record QuestionerDto(@JsonProperty(access = JsonProperty.Access.READ_ONLY) String lastName,
                            @JsonProperty(access = JsonProperty.Access.READ_ONLY) String firstName,
                            @NotBlank String surname, @NotNull LocalDate birthday, String faculty, String city,
                            String educationalInstitution, String admission, Integer levelCpp,
                            Integer levelPython, Integer levelJava, Integer levelCSharp,
                            Integer levelSql
) {
}
