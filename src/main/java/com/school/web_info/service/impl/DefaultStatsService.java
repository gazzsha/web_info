package com.school.web_info.service.impl;

import com.school.web_info.dto.filter.Filter;
import com.school.web_info.entity.questioner.Questioner;
import com.school.web_info.repository.StatsRepository;
import com.school.web_info.service.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DefaultStatsService implements StatsService {

    private final StatsRepository statsRepository;

    @Override
    public List<Questioner> getAllBuFilter(Filter filter) {
        return statsRepository.findAllByFilter(filter);
    }
}
