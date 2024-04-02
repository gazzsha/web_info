package com.school.web_info.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.web_info.entity.Answer;
import com.school.web_info.entity.ResultTest;
import com.school.web_info.entity.Test;
import com.school.web_info.entity.User;
import com.school.web_info.exception.error.NotFoundException;
import com.school.web_info.repository.ResultTestRepository;
import com.school.web_info.repository.TestRepository;
import com.school.web_info.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/school")
@AllArgsConstructor
@Slf4j
public class TestingController {
    private final TestRepository testRepository;

    private final UserRepository userRepository;

    private final ObjectMapper objectMapper;
    private final ResultTestRepository resultTestRepository;

    @GetMapping(value = "/test")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String getMainTestingPage(HttpServletRequest httpServletRequest, Principal principal, Model model) {
        model.addAttribute("test", testRepository.findAll());
        log.info(principal.getName());
        return "testing/main-testing-view";
    }

    @GetMapping(value = "/testing/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String getTests(@PathVariable(name = "id") String id, Model model) {
        System.out.println(id);
        Test test = testRepository.findBy_id(id);
        model.addAttribute("ans", test.getAnswerList());
        return "testing/testing-view";
    }

    @PostMapping(value = "/testing/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<?> postAnswer(HttpServletRequest httpServletRequest, @PathVariable(name = "id") String testId) throws IOException {
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
                () -> new NotFoundException(String.format("Не найдет тест с идентификатором %s", testId)));
        Long countRightAnswer = test.getAnswerList().stream().filter(ans -> answerUser.contains(ans.getRightAnswer())).count();
        ResultTest resultTest = resultTestRepository.findResultTestByUserAndTestId(user, testId).orElse(new ResultTest());
        resultTest.setCountTrueAnswer(countRightAnswer);
        resultTest.setUser(user);
        resultTest.setTestId(testId);
        resultTestRepository.save(resultTest);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .build();
    }


}
