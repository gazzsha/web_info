package com.school.web_info.entity;


import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "timetracking")
public class TimeTracking {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "peer")
    private String peerName;

    @Column(name ="\"Date\"")
    private Date date;


    @Column(name = "\"Time\"")
    private Time time;


    @Column(name = "state")
    private int state;

    public String getPeerName() {
        return peerName;
    }

    public void setPeerName(String peerName) {
        this.peerName = peerName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date Date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
