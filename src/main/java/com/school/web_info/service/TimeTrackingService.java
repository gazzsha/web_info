package com.school.web_info.service;

import com.school.web_info.entity.TimeTracking;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TimeTrackingService {



    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRES_NEW)
    List<TimeTracking> getAllTimeTracking(String name);
}
