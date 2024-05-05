package com.school.web_info.service;

import com.school.web_info.dto.filter.Filter;
import com.school.web_info.entity.questioner.Questioner;

import java.util.List;

public interface StatsService {

    List<Questioner> getAllBuFilter(Filter filter);
}
