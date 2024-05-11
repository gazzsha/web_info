package com.school.web_info.service;

import com.school.web_info.dto.filter.FilterUser;
import com.school.web_info.dto.questioner.QuestionerDto;
import com.school.web_info.entity.User;
import com.school.web_info.entity.questioner.Questioner;

import java.util.List;

public interface ProfileService {
    List<User> getAllUsers(FilterUser filter);

    Questioner getProfileUser(Long id);
}
