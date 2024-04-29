package com.school.web_info.controller;


import com.school.web_info.dto.FacultyDto;
import com.school.web_info.dto.admission.AdmissionDto;
import com.school.web_info.dto.institution.InstitutionDto;
import com.school.web_info.service.SurveyService;
import com.school.web_info.utils.mapper.AdmissionMapper;
import com.school.web_info.utils.mapper.FacultyMapper;
import com.school.web_info.utils.mapper.InstitutionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/school")
@RequiredArgsConstructor
public class SurveyController {

    private final SurveyService surveyService;

    private final FacultyMapper facultyMapper;

    private final InstitutionMapper institutionMapper;

    private final AdmissionMapper admissionMapper;

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
}
