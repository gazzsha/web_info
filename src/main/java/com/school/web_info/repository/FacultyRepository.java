package com.school.web_info.repository;

import com.school.web_info.entity.faculty.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Faculty findByFacultyName(String facultyName);
}
