package com.school.web_info.controller;

import com.school.web_info.entity.TimeTracking;
import com.school.web_info.service.TimeTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/school")
public class ControllerTimeTracking {

    @Autowired
    private final TimeTrackingService timeTrackingService;

    public ControllerTimeTracking(TimeTrackingService timeTrackingService) {
        this.timeTrackingService = timeTrackingService;
    }

    @GetMapping("/timetracking")
    public String showAllTimeTracking(@RequestParam(value = "nickname",required = false) String nickname,Model model) {
        List<TimeTracking> timeTrackingList = timeTrackingService.getAllTimeTracking(nickname);
        model.addAttribute("timetracking", timeTrackingList);
        System.out.println(nickname);
        return "timetracking/ViewAllTimeTracking";
    }



//    @GetMapping("/timetracking")
//    @ResponseBody
//    public List<TimeTracking> showAllTimeTracking(@RequestParam(value = "nickname",required = false) String nickname, Model model) {
//        System.out.println(nickname);
//        List<TimeTracking> timeTrackingList = timeTrackingService.getAllTimeTracking(nickname);
//        return timeTrackingList;
//    }
}
