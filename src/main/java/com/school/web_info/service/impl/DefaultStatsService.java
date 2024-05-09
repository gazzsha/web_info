package com.school.web_info.service.impl;

import com.school.web_info.dto.FacultyDto;
import com.school.web_info.dto.filter.Filter;
import com.school.web_info.entity.ResultTest;
import com.school.web_info.entity.User;
import com.school.web_info.entity.questioner.Questioner;
import com.school.web_info.repository.StatsRepository;
import com.school.web_info.service.FacultyService;
import com.school.web_info.service.QuestionaryService;
import com.school.web_info.service.ResultTestService;
import com.school.web_info.service.StatsService;
import com.school.web_info.service.TestService;
import com.school.web_info.service.UserService;
import com.school.web_info.utils.Pair;
import com.school.web_info.utils.mapper.FacultyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class DefaultStatsService implements StatsService {

    private final ResultTestService resultTestService;

    private final UserService userService;

    private final FacultyMapper facultyMapper;

    private final FacultyService facultyService;

    private final QuestionaryService questionaryService;

    private final TestService testService;

    private final StatsRepository statsRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Questioner> getAllBuFilter(Filter filter) {
        return statsRepository.findAllByFilter(filter);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FacultyDto> getAllFaculty() {
        return facultyMapper.toDto(facultyService.getAllFaculty());
    }

//    @Override
//    public Map<String, Map<FacultyDto, Float>> facultyAvgRatingByTest() {
//        List<String> testsId = testService.getAllTestsId();
//        List<ResultTest> allResultOfTest = resultTestService.findAll();
//        List<Questioner> allQuestioner = questionaryService.getAll();
//        allQuestioner.stream().collect(Collectors.toMap(Questioner::getFaculty, Questioner::getUser))
//                .entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> Collectors.toMap(e.getValue())));
//        Map<String, Map<User, Long>> collect = resultTestService.findAll()
//                .stream()
//                .collect(Collectors.groupingBy(ResultTest::getTestId,
//                        Collectors.groupingBy(ResultTest::getUser,
//                                Collectors.summingLong(ResultTest::getCountTrueAnswer))));
//
//
//    }
}
