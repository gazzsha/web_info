package com.school.web_info.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "peers")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Peer {

    @Id
    @Column(name = "Nickname")
    String nickname;

    @Column(name = "Birthday")
    Date birthday;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Peer")
    List<TimeTracking> timeTrackingList;


    public void addTimeTrackingToPeer(TimeTracking timeTracking) {
        if (timeTrackingList == null) {
            timeTrackingList = new ArrayList<>();
        }
        timeTrackingList.add(timeTracking);
    }

}
