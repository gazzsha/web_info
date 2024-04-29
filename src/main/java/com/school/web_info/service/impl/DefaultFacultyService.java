package com.school.web_info.service.impl;

import com.school.web_info.entity.faculty.Faculty;
import com.school.web_info.repository.FacultyRepository;
import com.school.web_info.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DefaultFacultyService implements FacultyService {

    private final FacultyRepository facultyRepository;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }
}
