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
@Table(name = "p2p")
@Getter
@Setter
@NoArgsConstructor
public class P2P {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"Check\"")
    @JsonBackReference
    Checks checks;


    @Column(name = "\"Check\"",insertable=false, updatable=false)
    @NotNull
    private int check;

    @Column(name = "checkingpeer")
    @NotNull
    private String checkingPeer;

    @Enumerated(EnumType.STRING)
    @Column(name = "\"State\"")
    @NotNull
    private State state;

    @Column(name = "\"Time\"")
    @NotNull
    private Time time;






}
