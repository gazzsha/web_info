package com.school.web_info.service.impl;

import com.school.web_info.entity.admission.Admission;
import com.school.web_info.entity.faculty.Faculty;
import com.school.web_info.entity.institution.EducationalInstitution;
import com.school.web_info.entity.questioner.Questioner;
import com.school.web_info.service.AdmissionService;
import com.school.web_info.service.EducationInstitutionService;
import com.school.web_info.service.FacultyService;
import com.school.web_info.service.QuestionaryService;
import com.school.web_info.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DefaultSurveyService implements SurveyService {


    private final EducationInstitutionService educationInstitutionService;
    private final FacultyService facultyService;
    private final AdmissionService admissionService;
    private final QuestionaryService questionaryService;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Faculty> getFaculty() {
        return facultyService.getAllFaculty();
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<EducationalInstitution> getAllEducations() {
        return educationInstitutionService.getAllEducations();
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Admission> getAllAdmission() {
        return admissionService.getAllAdmission();
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public Questioner createProfile(Object userObject, Questioner questioner, String faculty, String admission, String institution) {
        return questionaryService.createQuestioner(userObject, questioner, faculty, admission, institution);
    }

    @Override
    @Transactional(readOnly = true)
    public Questioner getUserProfile(Object userObject) {
        return questionaryService.getUserProfile(userObject);
    }


}
