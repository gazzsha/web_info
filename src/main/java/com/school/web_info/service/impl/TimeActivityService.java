package com.school.web_info.service.impl;

import com.school.web_info.entity.timeactivity.TimeActivity;
import com.school.web_info.entity.user.User;
import com.school.web_info.exception.error.NotFoundException;
import com.school.web_info.repository.TimeActivityRepository;
import com.school.web_info.repository.UserRepository;
import com.school.web_info.utils.Status;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.StringTokenizer;

@Service
@AllArgsConstructor
public class TimeActivityService {
    private final TimeActivityRepository timeActivityRepository;
    private final UserRepository userRepository;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void activityUser(Object userObject, Status status) {
        UserDetails userDetails = (UserDetails) userObject;
        StringTokenizer stringTokenizer = new StringTokenizer(userDetails.getUsername());
        User user = userRepository.findUserByNameAndLastName(stringTokenizer.nextToken(), stringTokenizer.nextToken())
                .orElseThrow(() -> new NotFoundException(String.format("Пользователь %s не найден", userDetails.getUsername())));
        TimeActivity timeActivity = new TimeActivity();
        timeActivity.setTime(Time.valueOf(LocalTime.now()));
        timeActivity.setDate(Date.valueOf(LocalDate.now()));
        timeActivity.setUser(user);
        timeActivity.setStatus(status);
        timeActivityRepository.saveAndFlush(timeActivity);
    }
}
