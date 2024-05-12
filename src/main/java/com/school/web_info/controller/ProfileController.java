package com.school.web_info.controller;

import com.school.web_info.dto.filter.FilterUser;
import com.school.web_info.dto.questioner.QuestionerDto;
import com.school.web_info.service.ProfileService;
import com.school.web_info.utils.Pair;
import com.school.web_info.utils.mapper.QuestinaryMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/school")
public class ProfileController {

    private final QuestinaryMapper questinaryMapper;

    private final ProfileService profileService;


    @GetMapping(value = "/profiles", produces = MediaType.TEXT_HTML_VALUE)
    public String getAllProfiles(Model model, HttpServletRequest request) {
        var filter = new FilterUser(request.getParameter("name"), request.getParameter("lastname"));
        var users = profileService.getAllUsers(filter);
        model.addAttribute("users", users);
        return "profile/main-page";
    }


    @GetMapping(value = "/profiles/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public String getProfile(@PathVariable(name = "id") Long id) {
        return "profile/profile-user-page";
    }


    @GetMapping(value = "/profiles/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuestionerDto> getUserProfile(Model model, @PathVariable(name = "id") Long id) {
        var questioner = questinaryMapper.toDto(profileService.getProfileUser(id));
        model.addAttribute("profile", questioner);
        return ResponseEntity.ok().body(questioner);
    }

    @GetMapping(value = "/profiles/user/{id}/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Pair<Long, Integer>>> getUserPassedTest(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(profileService.getUserPassedTest(id));
    }

}
