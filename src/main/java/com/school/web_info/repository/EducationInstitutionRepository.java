package com.school.web_info.repository;

import com.school.web_info.entity.institution.EducationalInstitution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EducationInstitutionRepository extends JpaRepository<EducationalInstitution, Long> {

    EducationalInstitution findByInstitution(String institution);
}
