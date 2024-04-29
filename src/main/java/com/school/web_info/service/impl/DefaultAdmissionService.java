package com.school.web_info.service.impl;

import com.school.web_info.entity.admission.Admission;
import com.school.web_info.repository.AdmissionRepository;
import com.school.web_info.service.AdmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultAdmissionService implements AdmissionService {

    private final AdmissionRepository admissionRepository;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Admission> getAllAdmission() {
        return admissionRepository.findAll();
    }
}
