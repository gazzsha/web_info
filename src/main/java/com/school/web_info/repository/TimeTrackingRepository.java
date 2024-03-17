package com.school.web_info.repository;

import com.school.web_info.entity.TimeTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeTrackingRepository extends JpaRepository<TimeTracking,Integer> {
    List<TimeTracking> findTimeTrackingByPeerNameStartingWith(String username);
}
