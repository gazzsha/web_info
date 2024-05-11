package com.school.web_info.controller;


import com.school.web_info.dto.filter.ResultTestFilter;
import com.school.web_info.service.impl.DefaultResultTestService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/school")
public class ResultTestController {
    private final DefaultResultTestService defaultResultTestService;


    @GetMapping(value = "/results", produces = MediaType.TEXT_HTML_VALUE)
    public String getPassedTest(Model model, ResultTestFilter filter) {
        model.addAttribute("results", defaultResultTestService.getPassedTest(filter));
        return "result-test/result-test-view";
    }

}
