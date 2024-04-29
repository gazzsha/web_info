package com.school.web_info.service;

import com.school.web_info.entity.admission.Admission;
import com.school.web_info.entity.faculty.Faculty;
import com.school.web_info.entity.institution.EducationalInstitution;

import java.util.List;

public interface SurveyService {
    List<Faculty> getFaculty();

    List<EducationalInstitution> getAllEducations();

    List<Admission> getAllAdmission();
}
