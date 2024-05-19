package com.school.web_info.service.impl;

import com.school.web_info.dto.filter.FilterUser;
import com.school.web_info.entity.user.User;
import com.school.web_info.entity.questioner.Questioner;
import com.school.web_info.repository.impl.UserRepositoryImpl;
import com.school.web_info.service.ProfileService;
import com.school.web_info.service.QuestionaryService;
import com.school.web_info.service.ResultTestService;
import com.school.web_info.service.TestService;
import com.school.web_info.utils.Pair;
import com.school.web_info.utils.third.Third;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultProfileService implements ProfileService {

    private final ResultTestService resultTestService;

    private final QuestionaryService questionaryService;

    private final UserRepositoryImpl userRepository;

    private final TestService testService;

    @Override
    public List<User> getAllUsers(FilterUser filter) {
        return userRepository.findAllByFilter(filter);
    }

    @Override
    public Questioner getProfileUser(Long id) {
        return questionaryService.getUserProfileById(id);
    }

    @Override
    public Map<String, Pair<Long, Integer>> getUserPassedTest(Long id) {
        return resultTestService.getAllByUserId(id).stream().map(rs -> {
            var test = testService.getById(rs.getTestId());
            String name = test.getName();
            Integer countQuestions = test.getAnswerList().size();
            Long rightAnswerByUser = rs.getCountTrueAnswer();
            return new Third<>(name, rightAnswerByUser, countQuestions);
        }).collect(Collectors.toMap(Third::first, th -> new Pair<>(th.Second(), th.third())));
    }
}
