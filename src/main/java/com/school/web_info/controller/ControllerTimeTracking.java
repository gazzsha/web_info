package com.school.web_info.controller;

import com.school.web_info.dto.TimeTrackingDTO;
import com.school.web_info.entity.TimeTracking;
import com.school.web_info.service.TimeTrackingService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.school.web_info.controller.ControllerTimeTracking.API;

@Controller
@RequestMapping(API)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ControllerTimeTracking {

    static final String API = "/school";
    static final String GET_TIME_TRACKING = "/timetracking";

    TimeTrackingService timeTrackingService;

    @GetMapping(GET_TIME_TRACKING)
    public String showAllTimeTracking(@RequestParam(value = "nickname", required = false) String nickname, Model model) {
        List<TimeTrackingDTO> timeTrackingList = timeTrackingService.getAllTimeTracking(nickname)
                .stream()
                .map(value -> TimeTrackingDTO.builder()
                        .peerName(value.getPeerName())
                        .date(value.getDate())
                        .time(value.getTime())
                        .state(value.getState())
                        .build()).toList();
        model.addAttribute("timetracking", timeTrackingList);
        return "timetracking/ViewAllTimeTracking";
    }


}
