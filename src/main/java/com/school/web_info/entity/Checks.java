package com.school.web_info.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "checks")
@Getter
@Setter
@NoArgsConstructor
public class Checks {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "peer")
    private String peer;

    @Column(name = "task")
    @PrimaryKeyJoinColumn
    private String nameTask;

    @Column(name = "date")
    private Date date;

    @OneToMany(mappedBy = "checks")
    @JsonManagedReference
    private List<P2P> p2p = new ArrayList<>();


    @OneToMany(mappedBy = "checks")
    @JsonManagedReference
    private List<Verter> verter;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "checks")
    @JsonManagedReference
    private XP xp;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "checks")
    @JsonManagedReference
    private Task task;
}
