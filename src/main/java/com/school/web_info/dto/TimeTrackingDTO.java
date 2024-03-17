package com.school.web_info.dto;

import lombok.Builder;

import java.sql.Date;
import java.sql.Time;

@Builder
public record TimeTrackingDTO(String peerName, Date date, Time time,Integer state){}
