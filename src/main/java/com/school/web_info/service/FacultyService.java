package com.school.web_info.service;

import com.school.web_info.entity.faculty.Faculty;

import java.util.List;

public interface FacultyService {

    List<Faculty> getAllFaculty();

    Faculty getByFacultyName(String facultyName);
}
