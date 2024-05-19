package com.school.web_info.service;

import com.school.web_info.dto.filter.FilterUser;
import com.school.web_info.entity.questioner.Questioner;
import com.school.web_info.entity.user.User;
import com.school.web_info.utils.Pair;

import java.util.List;
import java.util.Map;

public interface ProfileService {
    List<User> getAllUsers(FilterUser filter);

    Questioner getProfileUser(Long id);

    Map<String, Pair<Long, Integer>> getUserPassedTest(Long id);
}
