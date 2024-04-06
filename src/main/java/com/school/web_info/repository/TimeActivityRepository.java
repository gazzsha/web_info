package com.school.web_info.repository;

import com.school.web_info.entity.TimeActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeActivityRepository extends JpaRepository<TimeActivity, Long> {
}