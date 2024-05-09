package com.school.web_info.service.impl;


import com.school.web_info.dto.ResultTestDto;
import com.school.web_info.dto.TestShortInfoDto;
import com.school.web_info.entity.ResultTest;
import com.school.web_info.repository.ResultTestRepository;
import com.school.web_info.service.ResultTestService;
import com.school.web_info.service.TestService;
import com.school.web_info.utils.Pair;
import com.school.web_info.utils.PojoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DefaultResultTestService implements ResultTestService {
    private final TestService testService;
    private final ResultTestRepository resultTestRepository;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public List<Pair<TestShortInfoDto, List<ResultTestDto>>> getPassedTest() {
        return resultTestRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(ResultTest::getTestId,
                        Collectors.mapping(test -> PojoMapper.INSTANCE.resultTestToResultTestDto(resultTestRepository.findResultTestByUserAndTestId(test.getUser(),
                                test.getTestId()).get()), Collectors.toList())))
                .entrySet().stream()
                .map(entry -> new Pair<>(PojoMapper.INSTANCE.testToTestShortDto(testService.getById(entry.getKey())),
                        entry.getValue())).toList();
    }

    @Override
    public List<ResultTest> findAll() {
        return resultTestRepository.findAll();
    }
}
