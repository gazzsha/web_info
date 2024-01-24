package com.school.web_info.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.school.web_info.utils.State;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Entity
@Table(name = "verter")
@Getter
@Setter
@NoArgsConstructor
public class Verter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private int id;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "\"State\"")
    private State state;

    @Column(name = "\"Check\"",insertable=false, updatable=false)
    @NotNull
    private int check;


    @Column(name = "\"Time\"")
    @NotNull
    private Time time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"Check\"")
    @JsonBackReference
    private Checks checks;
}
