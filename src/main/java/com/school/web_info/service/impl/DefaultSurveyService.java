package com.school.web_info.service.impl;

import com.school.web_info.entity.admission.Admission;
import com.school.web_info.entity.faculty.Faculty;
import com.school.web_info.entity.institution.EducationalInstitution;
import com.school.web_info.service.AdmissionService;
import com.school.web_info.service.EducationInstitutionService;
import com.school.web_info.service.FacultyService;
import com.school.web_info.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DefaultSurveyService implements SurveyService {


    private final EducationInstitutionService educationInstitutionService;
    private final FacultyService facultyService;
    private final AdmissionService admissionService;

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


}
