package com.school.web_info.entity.answer;

import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Answer {
    @NotNull
    @NotBlank(message = "Поле вопрос не должно быть пустым")
    private String question;
    @NotNull
    @Valid
    private List<@NotBlank(message = "Вопрос не должен быть пустым") String> answers;
    @NotNull
    @NotBlank(message = "Поле верный ответ не должно быть пустым")
    private String rightAnswer;
}
