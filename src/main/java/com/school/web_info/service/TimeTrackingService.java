package com.school.web_info.service;

import com.school.web_info.entity.TimeTracking;

import java.util.List;

public interface TimeTrackingService {
    List<TimeTracking> getAllTimeTracking(String name);
}
