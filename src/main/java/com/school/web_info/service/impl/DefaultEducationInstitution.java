package com.school.web_info.service.impl;

import com.school.web_info.entity.institution.EducationalInstitution;
import com.school.web_info.repository.EducationInstitutionRepository;
import com.school.web_info.service.EducationInstitutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DefaultEducationInstitution implements EducationInstitutionService {

    private final EducationInstitutionRepository educationInstitutionRepository;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<EducationalInstitution> getAllEducations() {
        return educationInstitutionRepository.findAll();
    }
}
