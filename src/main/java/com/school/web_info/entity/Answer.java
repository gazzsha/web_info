package com.school.web_info.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Answer {
    @NotNull
    private String question;
    @NotNull
    private List<String> answers;
    @NotNull
    private String rightAnswer;
}
