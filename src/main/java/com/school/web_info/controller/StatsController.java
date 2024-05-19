package com.school.web_info.controller;


import com.school.web_info.service.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(value = "/school")
@RequiredArgsConstructor
public class StatsController {

    private final StatsService statsService;


    @GetMapping(value = "/stats", produces = MediaType.TEXT_HTML_VALUE)
    public String getMain() {
        return "stats/stats-main-view";
    }

    @GetMapping(value = "/stats_result", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Map<String, Double>> getStats() {
        return statsService.facultyAvgRatingByTest();
    }


}
