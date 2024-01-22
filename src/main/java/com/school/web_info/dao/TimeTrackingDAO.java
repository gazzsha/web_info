package com.school.web_info.dao;

import com.school.web_info.entity.TimeTracking;

import java.util.List;

public interface TimeTrackingDAO {

    List<TimeTracking> getAllTimeTracking(String nickname);
}
