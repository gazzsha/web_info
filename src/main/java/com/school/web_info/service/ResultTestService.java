package com.school.web_info.service;

import com.school.web_info.dto.ResultTestDto;
import com.school.web_info.dto.TestShortInfoDto;
import com.school.web_info.entity.ResultTest;
import com.school.web_info.utils.Pair;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResultTestService {
    List<Pair<TestShortInfoDto, List<ResultTestDto>>> getPassedTest();


    @Query("from ResultTest r join fetch User u on r.user = u")
    List<ResultTest> findAll();
}
