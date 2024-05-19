package com.school.web_info.controller;


import com.school.web_info.dto.daculty.FacultyDto;
import com.school.web_info.dto.admission.AdmissionDto;
import com.school.web_info.dto.institution.InstitutionDto;
import com.school.web_info.dto.questioner.QuestionerDto;
import com.school.web_info.service.SurveyService;
import com.school.web_info.utils.mapper.AdmissionMapper;
import com.school.web_info.utils.mapper.FacultyMapper;
import com.school.web_info.utils.mapper.InstitutionMapper;
import com.school.web_info.utils.mapper.QuestinaryMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/school")
@RequiredArgsConstructor
@Validated
public class SurveyController {

    private final SurveyService surveyService;

    private final FacultyMapper facultyMapper;

    private final InstitutionMapper institutionMapper;

    private final AdmissionMapper admissionMapper;
    private final QuestinaryMapper questinaryMapper;

    @GetMapping(value = "/survey", produces = MediaType.TEXT_HTML_VALUE)
    public String getSurvey(Model model) {
        List<FacultyDto> facultyDtos = facultyMapper.toDto(surveyService.getFaculty());
        List<InstitutionDto> institutionDtos = institutionMapper.toDto(surveyService.getAllEducations());
        List<AdmissionDto> admissionDtos = admissionMapper.toDto(surveyService.getAllAdmission());
        model.addAttribute("faculties", facultyDtos);
        model.addAttribute("institutions", institutionDtos);
        model.addAttribute("admissions", admissionDtos);
        return "questionary/questionary-main-view";
    }


    @GetMapping(value = "/survey/my", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuestionerDto> getUserQuestioner(HttpServletRequest httpServletRequest) {
        QuestionerDto userQuestion = questinaryMapper.toDto(surveyService.getUserProfile(((Authentication) httpServletRequest.getUserPrincipal()).getPrincipal()));
        return ResponseEntity.ok().body(userQuestion);
    }

    @PostMapping(value = "/survey", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createProfile(HttpServletRequest httpServletRequest, @RequestBody @Valid QuestionerDto questionerDto) {
        surveyService.createProfile(((Authentication) httpServletRequest.getUserPrincipal()).getPrincipal(),
                questinaryMapper.toEntity(questionerDto), questionerDto.faculty(), questionerDto.admission(), questionerDto.educationalInstitution());
        return ResponseEntity.ok().build();
    }
}
