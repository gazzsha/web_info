package com.school.web_info.service;


import com.school.web_info.dto.ResultTestDto;
import com.school.web_info.dto.TestDto;
import com.school.web_info.dto.TestShortInfoDto;
import com.school.web_info.entity.ResultTest;
import com.school.web_info.entity.Test;
import com.school.web_info.entity.User;
import com.school.web_info.repository.ResultTestRepository;
import com.school.web_info.repository.TestRepository;
import com.school.web_info.repository.UserRepository;
import com.school.web_info.utils.Pair;
import com.school.web_info.utils.PojoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ResultTestService {
    private final TestRepository testRepository;
    private final ResultTestRepository resultTestRepository;
    private final UserRepository userRepository;


    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public List<Pair<TestShortInfoDto, List<ResultTestDto>>> getPassedTest() {
//        return testRepository.findAll()
//                .stream()
//                .collect(Collectors.groupingBy(Test::get_id,
//                        Collectors.mapping(test -> PojoMapper.INSTANCE.resultTestToResultTestDto(resultTestRepository.findResultTestByTestId(test.get_id())), Collectors.toList())))
//                .entrySet().stream().collect(Collectors.toMap(
//                        entry -> PojoMapper.INSTANCE.testToTestShortDto(testRepository.findBy_id(entry.getKey())),
//                        Map.Entry::getValue,
//                        (e1, e2) -> {
//                            throw new RuntimeException();
//                        },
//                        LinkedHashMap::new));
        return resultTestRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(ResultTest::getTestId,
                        Collectors.mapping(test -> PojoMapper.INSTANCE.resultTestToResultTestDto(resultTestRepository.findResultTestByUserAndTestId(test.getUser(),
                                test.getTestId()).get()), Collectors.toList())))
                .entrySet().stream()
                .map(entry -> new Pair<>(PojoMapper.INSTANCE.testToTestShortDto(testRepository.findBy_id(entry.getKey())),
                        entry.getValue())).collect(Collectors.toList());
    }
}
