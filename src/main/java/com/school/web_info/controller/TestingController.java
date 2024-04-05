package com.school.web_info.controller;

import com.school.web_info.dto.TestDto;
import com.school.web_info.entity.ResultTest;
import com.school.web_info.service.TestingService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping(value = "/school")
@AllArgsConstructor
public class TestingController {

    private final TestingService testingService;

    @GetMapping(value = "/test")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String getMainTestingPage(Model model) {
        model.addAttribute("test", testingService.getAllTest());
        return "testing/main-testing-view";
    }

    @GetMapping(value = "/testing/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String getTests(@PathVariable(name = "id") String id, Model model) {
        TestDto test = testingService.findTestById(id);
        model.addAttribute("ans", test.answerList());
        return "testing/testing-view";
    }

    @PostMapping(value = "/testing/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<ResultTest> postAnswer(HttpServletRequest httpServletRequest, @PathVariable(name = "id") String testId) throws IOException {
        ResultTest result = testingService.saveUserAnswer(httpServletRequest, testId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }


}
