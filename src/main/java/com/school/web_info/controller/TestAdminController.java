package com.school.web_info.controller;

import com.school.web_info.dto.TestDto;
import com.school.web_info.service.TestService;
import com.school.web_info.utils.mapper.TestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/school/admin")
@RequiredArgsConstructor
@Validated
public class TestAdminController {

    private final TestMapper testMapper;

    private final TestService testService;

    @GetMapping("/test")
    public String createTest() {
        return "test/test-view";
    }

    @PostMapping("/test")
    public ResponseEntity<Void> addTest(@RequestBody @Valid TestDto dto) {
        testService.save(testMapper.toEntity(dto));
        return ResponseEntity.ok().build();
    }
}
