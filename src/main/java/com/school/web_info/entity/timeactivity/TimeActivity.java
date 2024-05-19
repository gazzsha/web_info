package com.school.web_info.entity.timeactivity;

import com.school.web_info.entity.user.User;
import com.school.web_info.utils.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Date;
import java.sql.Time;


@Entity
@Table(name = "activity_time")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class TimeActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @NotNull
    @Column(name = "date", nullable = false, updatable = false)
    private Date date;

    @NotNull
    @Column(name = "time", nullable = false, updatable = false)
    private Time time;

    @NotNull
    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private Status status;
}
