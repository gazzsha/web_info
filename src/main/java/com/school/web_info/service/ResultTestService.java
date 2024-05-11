package com.school.web_info.service;

import com.school.web_info.dto.ResultTestDto;
import com.school.web_info.dto.TestShortInfoDto;
import com.school.web_info.dto.filter.ResultTestFilter;
import com.school.web_info.entity.ResultTest;
import com.school.web_info.utils.Pair;

import java.util.List;

public interface ResultTestService {
    List<Pair<TestShortInfoDto, List<ResultTestDto>>> getPassedTest(ResultTestFilter filter);


    List<ResultTest> getAll();
}
