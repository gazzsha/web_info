package com.school.web_info.controller;

import com.school.web_info.entity.Answer;
import com.school.web_info.entity.Test;
import com.school.web_info.repository.TestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/school")
@Slf4j
public class TestingController {
    private final TestRepository testRepository;


    public static final String GET_TESTS = "/test";

    public static final String GET_TEST = "/testing";

    public static final String GET_CURRENT_ANSWER = "/testing/answer";

    public TestingController(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @GetMapping(GET_TESTS)
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String getMainTestingPage(Principal principal) {
        log.info(principal.getName());
        return "testing/main-testing-view";
    }

    @GetMapping(GET_TEST)
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String getTests(Model model) {
        List<Test> test = testRepository.findAll();
        model.addAttribute("test", test.get(0).getAnswerList());
        return "testing/testing-view";
    }

    @GetMapping(GET_CURRENT_ANSWER)
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<?> getAnswer() {
        List<Test> test = testRepository.findAll();
        List<Answer> answerList = test.get(0).getAnswerList();
        String[] array = answerList.stream().map(Answer::getRightAnswer).toArray(String[]::new);
        return ResponseEntity.ok(array);
    }


}
