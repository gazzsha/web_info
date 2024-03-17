package com.school.web_info.service;

import com.school.web_info.dao.TimeTrackingDAO;
import com.school.web_info.dto.TimeTrackingDTO;
import com.school.web_info.entity.TimeTracking;
import com.school.web_info.repository.TimeTrackingRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TimeTrackingServiceImplementation implements TimeTrackingService {


    TimeTrackingRepository timeTrackingRepository;


    @Override
    public List<TimeTracking> getAllTimeTracking(String nickname) {
        if (Objects.isNull(nickname))
            return timeTrackingRepository.findAll();
        return timeTrackingRepository.findTimeTrackingByPeerNameStartingWith(nickname);
    }


}
