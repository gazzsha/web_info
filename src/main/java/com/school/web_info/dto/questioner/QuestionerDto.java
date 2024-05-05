package com.school.web_info.dto.questioner;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public record QuestionerDto(@JsonProperty(access = JsonProperty.Access.READ_ONLY) String lastName,
                            @JsonProperty(access = JsonProperty.Access.READ_ONLY) String firstName,
                            @NotBlank String surname,
                            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") @NotNull Date birthday,
                            String faculty, String city,
                            String educationalInstitution, String admission, Integer levelCpp,
                            Integer levelPython, Integer levelJava, Integer levelCSharp,
                            Integer levelSql
) {
}
