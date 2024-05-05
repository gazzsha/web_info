package com.school.web_info.controller;


import com.school.web_info.service.StatsService;
import com.school.web_info.utils.mapper.QuestinaryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/school")
@RequiredArgsConstructor
public class StatsController {
    private final QuestinaryMapper questinaryMapper;

    private final StatsService statsService;


//    @GetMapping(value = "/stats", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<QuestionerDto>> getQuestionerByFilter(Filter filter) {
//        return ResponseEntity.ok(questinaryMapper.toDto(statsService.getAllBuFilter(filter)));
//    }

    @GetMapping(value = "/stats", produces = MediaType.TEXT_HTML_VALUE)
    public String getMain() {
        return "stats/stats-main-view";
    }


}
