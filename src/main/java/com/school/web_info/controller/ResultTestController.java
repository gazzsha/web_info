package com.school.web_info.controller;


import com.school.web_info.dto.ResultTestDto;
import com.school.web_info.dto.TestShortInfoDto;
import com.school.web_info.service.ResultTestService;
import com.school.web_info.utils.Pair;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/school")
public class ResultTestController {
    private final ResultTestService resultTestService;


    @GetMapping(value = "/results")
    private String getPassedTest(Model model) {
        model.addAttribute("results",resultTestService.getPassedTest());
        return "result-test/result-test-view";
    //    return resultTestService.getPassedTest();
    }

}
