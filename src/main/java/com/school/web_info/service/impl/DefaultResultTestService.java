package com.school.web_info.service.impl;


import com.school.web_info.dto.ResultTestDto;
import com.school.web_info.dto.TestShortInfoDto;
import com.school.web_info.dto.filter.ResultTestFilter;
import com.school.web_info.entity.ResultTest;
import com.school.web_info.entity.User;
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
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DefaultResultTestService implements ResultTestService {
    private final TestService testService;
    private final ResultTestRepository resultTestRepository;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public List<Pair<TestShortInfoDto, List<ResultTestDto>>> getPassedTest(ResultTestFilter filter) {
        return resultTestRepository.findAll()
                .stream()
                .filter(r -> {
                    User user = r.getUser();
                    if (Objects.nonNull(filter.name()) || Objects.nonNull(filter.lastName()))
                        return user.getName().equals(filter.name()) || user.getLastName().equals(filter.name());
                    return true;
                })
                .collect(Collectors.groupingBy(ResultTest::getTestId,
                        Collectors.mapping(test -> PojoMapper.INSTANCE.resultTestToResultTestDto(resultTestRepository.findResultTestByUserAndTestId(test.getUser(),
                                test.getTestId())), Collectors.toList())))
                .entrySet().stream()
                .map(entry -> new Pair<>(PojoMapper.INSTANCE.testToTestShortDto(testService.getById(entry.getKey())),
                        entry.getValue())).toList();
    }

    @Override
    public List<ResultTest> getAll() {
        return resultTestRepository.findAll();
    }

    @Override
    public List<ResultTest> getAllByUserId(Long id) {
        return resultTestRepository.findAllByUserId(id);
    }
}
