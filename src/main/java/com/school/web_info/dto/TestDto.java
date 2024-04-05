package com.school.web_info.dto;

import com.school.web_info.entity.Answer;

import java.util.List;

public record TestDto(String _id,String name, String title, String description, String imgUrl,
                      List<Answer> answerList) {
}
