package com.school.web_info.controller;


import com.school.web_info.dto.ResultTestDto;
import com.school.web_info.entity.ResultTest;
import com.school.web_info.service.ResultTestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/school")
public class ResultTestController {
    private final ResultTestService resultTestService;


    @GetMapping(value = "/results")
    @ResponseBody
    private ResponseEntity<Map<String, List<ResultTestDto>>> getPassedTest() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(resultTestService.getPassedTest());
    }

}
