package com.school.web_info.service.impl;

import com.school.web_info.dto.filter.FilterUser;
import com.school.web_info.entity.User;
import com.school.web_info.entity.questioner.Questioner;
import com.school.web_info.repository.impl.UserRepositoryImpl;
import com.school.web_info.service.ProfileService;
import com.school.web_info.service.QuestionaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultProfileService implements ProfileService {

    private final QuestionaryService questionaryService;

    private final UserRepositoryImpl userRepository;

    @Override
    public List<User> getAllUsers(FilterUser filter) {
        return userRepository.findAllByFilter(filter);
    }

    @Override
    public Questioner getProfileUser(Long id) {
        return questionaryService.getUserProfileById(id);
    }
}
