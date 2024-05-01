package com.school.web_info.service;

import com.school.web_info.entity.institution.EducationalInstitution;

import java.util.List;

public interface EducationInstitutionService {

    List<EducationalInstitution> getAllEducations();

    EducationalInstitution getEducationInstitution(String institution);

}
