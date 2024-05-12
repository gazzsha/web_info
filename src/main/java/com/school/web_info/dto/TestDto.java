package com.school.web_info.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.school.web_info.entity.Answer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record TestDto(@JsonProperty(access = JsonProperty.Access.READ_ONLY) String _id,
                      @NotBlank(message = "Название теста не должно быть пустым") String name,
                      @NotBlank(message = "Заголовок теста не должно быть пустым") String title,
                      @NotBlank(message = "Описание теста не должно быть пустым") String description,
                      @NotBlank(message = "Тест должен иметь изображение") String imgUrl,
                      @NotNull @Valid List<Answer> answerList) {
}
