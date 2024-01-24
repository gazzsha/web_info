package com.school.web_info.controller;

import com.school.web_info.entity.Checks;
import com.school.web_info.entity.P2P;
import com.school.web_info.service.ChecksService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/school")
@Controller
@AllArgsConstructor
public class ControllerChecks {

    private final ChecksService checksService;

    @GetMapping("/checks")
    @ResponseBody
    public List<Checks> showp2pList() {
        List<Checks> checksList =  checksService.getAllChecks();
        return checksList;
    }
}
