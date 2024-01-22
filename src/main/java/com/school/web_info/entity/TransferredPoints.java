package com.school.web_info.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transferredpoints")
@NoArgsConstructor
@Getter
@Setter
public class TransferredPoints {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "checkingpeer")
    String checkingPeer;

    @Column(name = "checkedpeer")
    String checkedPeer;

    @Column(name = "pointamount")
    private int points;
}
