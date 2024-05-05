package com.school.web_info.repository;

import com.school.web_info.dto.filter.Filter;
import com.school.web_info.entity.questioner.Questioner;

import java.util.List;

public interface StatsRepository {
    List<Questioner> findAllByFilter(Filter filter);
}
