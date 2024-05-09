package com.school.web_info.service;

import com.school.web_info.dto.FacultyDto;
import com.school.web_info.dto.filter.Filter;
import com.school.web_info.entity.questioner.Questioner;

import java.util.List;
import java.util.Map;

public interface StatsService {

    List<Questioner> getAllBuFilter(Filter filter);

    List<FacultyDto> getAllFaculty();

    Map<String, Map<FacultyDto, Float>> facultyAvgRatingByTest();
}
