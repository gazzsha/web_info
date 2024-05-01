package com.school.web_info.repository;

import com.school.web_info.entity.admission.Admission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRepository extends JpaRepository<Admission, Long> {

    Admission findByAdmissionVariant(String admissionVariant);
}
