package com.school.web_info.controller;

import com.school.web_info.entity.Answer;
import com.school.web_info.entity.Test;
import com.school.web_info.repository.TestRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class TestingController {

    public static final String GET_TESTS = "/test";

    public static final String GET_TEST = "/testing";

    public static final String GET_CURRENT_ANSWER = "/testing/answer";
    TestRepository testRepository;

    @GetMapping(GET_TESTS)
    public String getMainTestingPage () {
        return "testing/main-testing-view";
    }

    @GetMapping(GET_TEST)
    public String getTests(Model model) {
        List<Test> test = testRepository.findAll();
        model.addAttribute("test",test.get(0).getAnswerList());
        return "testing/testing-view";
    }

    @GetMapping(GET_CURRENT_ANSWER)
    public ResponseEntity<?> getAnswer() {
        List<Test> test = testRepository.findAll();
        List<Answer> answerList = test.get(0).getAnswerList();
        String[] array = answerList.stream().map(Answer::getRightAnswer).toArray(String[]::new);
        return ResponseEntity.ok(array);
    }


}
