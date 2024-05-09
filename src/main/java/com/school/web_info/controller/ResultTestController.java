package com.school.web_info.controller;


import com.school.web_info.service.impl.DefaultResultTestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/school")
public class ResultTestController {
    private final DefaultResultTestService defaultResultTestService;


    @GetMapping(value = "/results")
    private String getPassedTest(Model model) {
        model.addAttribute("results", defaultResultTestService.getPassedTest());
        return "result-test/result-test-view";
    //    return resultTestService.getPassedTest();
    }

}
