package com.school.web_info.controller;

import com.school.web_info.entity.TransferredPoints;
import com.school.web_info.service.TransferredPointService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/school")
@AllArgsConstructor
public class ControllerTransferredPoints {

    private final TransferredPointService transferredPointService;

    @GetMapping("/transferredpoints")
    public String showAllTransferredPoints(Model model) {
        List<TransferredPoints> transferredPointsList = transferredPointService.getAllTransferredPoints();
        model.addAttribute("transferredPoints",transferredPointsList);
        return "transferredpoints/transferred-points";
    }
}
