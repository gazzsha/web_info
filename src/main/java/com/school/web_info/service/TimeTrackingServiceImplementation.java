package com.school.web_info.service;

import com.school.web_info.dao.TimeTrackingDAO;
import com.school.web_info.entity.TimeTracking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.List;

@Service
public class TimeTrackingServiceImplementation implements TimeTrackingService {

    @Autowired
    private final TimeTrackingDAO timeTrackingDAO;

    public TimeTrackingServiceImplementation(TimeTrackingDAO timeTrackingDAO) {
        this.timeTrackingDAO = timeTrackingDAO;
    }

    @Override
    @Transactional
    public List<TimeTracking> getAllTimeTracking(String nickname) {
        return timeTrackingDAO.getAllTimeTracking(nickname);
    }

}
