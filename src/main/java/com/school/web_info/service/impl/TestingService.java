package com.school.web_info.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.web_info.dto.test.TestDto;
import com.school.web_info.entity.resulttest.ResultTest;
import com.school.web_info.entity.test.Test;
import com.school.web_info.entity.user.User;
import com.school.web_info.exception.error.NotFoundException;
import com.school.web_info.repository.ResultTestRepository;
import com.school.web_info.repository.TestRepository;
import com.school.web_info.repository.UserRepository;
import com.school.web_info.utils.PojoMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TestingService {

    private final TestRepository testRepository;

    private final ObjectMapper objectMapper;

    private final UserRepository userRepository;

    private final ResultTestRepository resultTestRepository;


    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<TestDto> getAllTest() {
        return testRepository.findAll().stream().map(PojoMapper.INSTANCE::testToTestDto).collect(Collectors.toList());
    }


    @Transactional(isolation = Isolation.READ_COMMITTED)
    public TestDto findTestById(String id) {
        return PojoMapper.INSTANCE.testToTestDto(testRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Тест с идентификатором %s не найдет", id))));
    }


    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public ResultTest saveUserAnswer(HttpServletRequest httpServletRequest, String testId) throws IOException {
        UserDetails userDetails = (UserDetails) ((Authentication) httpServletRequest.getUserPrincipal()).getPrincipal();
        StringTokenizer stringTokenizer = new StringTokenizer(userDetails.getUsername());
        User user = userRepository.findUserByNameAndLastName(stringTokenizer.nextToken(), stringTokenizer.nextToken()).get();
        StringBuilder body = new StringBuilder();
        String line;
        while ((line = httpServletRequest.getReader().readLine()) != null) {
            body.append(line);
        }
        String response = body.toString();
        LinkedHashMap responseJson = (LinkedHashMap) objectMapper.readValue(response, Object.class);
        final List<String> answerUser = ((List<String>) responseJson.get("data")).stream().filter(Objects::nonNull).collect(Collectors.toList());
        Test test = testRepository.findById(testId).orElseThrow(
                () -> new NotFoundException(String.format("Не найден тест с идентификатором %s", testId)));
        Long countRightAnswer = test.getAnswerList().stream().filter(ans -> answerUser.contains(ans.getRightAnswer())).count();
        ResultTest resultTest = resultTestRepository.findResultTestByUserAndTestId(user, testId);
        if (Objects.isNull(resultTest)) resultTest = new ResultTest();
        resultTest.setCountTrueAnswer(countRightAnswer);
        resultTest.setUser(user);
        resultTest.setTestId(testId);
        return resultTestRepository.save(resultTest);
    }
}
