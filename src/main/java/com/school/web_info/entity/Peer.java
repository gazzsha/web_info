package com.school.web_info.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "peers")
public class Peer {

    @Id
    @Column(name = "Nickname")
    private String nickname;

    @Column(name = "Birthday")
    private Date birthday;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Peer")
    private List<TimeTracking> timeTrackingList;

    public Peer() {
    }



    public Peer(String nickname, Date birthday) {
        this.nickname = nickname;
        this.birthday = birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void addTimeTrackingToPeer(TimeTracking timeTracking) {
        if (timeTrackingList == null) {
            timeTrackingList = new ArrayList<>();
        }
        timeTrackingList.add(timeTracking);
    }

}
