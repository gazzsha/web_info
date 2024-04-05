package com.school.web_info.service;


import com.school.web_info.dto.ResultTestDto;
import com.school.web_info.entity.ResultTest;
import com.school.web_info.entity.Test;
import com.school.web_info.entity.User;
import com.school.web_info.repository.ResultTestRepository;
import com.school.web_info.repository.TestRepository;
import com.school.web_info.repository.UserRepository;
import com.school.web_info.utils.PojoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ResultTestService {
    private final TestRepository testRepository;
    private final ResultTestRepository resultTestRepository;
    private final UserRepository userRepository;


    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Map<String, List<ResultTestDto>> getPassedTest() {
        return testRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(Test::getName,
                        Collectors.mapping(test -> PojoMapper.INSTANCE.resultTestToResultTestDto(resultTestRepository.findResultTestByTestId(test.get_id())), Collectors.toList())));

    }
}
