package com.school.web_info.service;

import com.school.web_info.dto.filter.FilterUser;
import com.school.web_info.entity.User;
import com.school.web_info.entity.questioner.Questioner;
import com.school.web_info.utils.Pair;
import com.school.web_info.utils.third.Third;

import java.util.List;
import java.util.Map;

public interface ProfileService {
    List<User> getAllUsers(FilterUser filter);

    Questioner getProfileUser(Long id);

    Map<String, Pair<Long,Integer>> getUserPassedTest(Long id);
}
