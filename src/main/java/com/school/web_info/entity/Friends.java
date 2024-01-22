package com.school.web_info.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "friends")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Friends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID\"")
    private int id;

    @Column(name = "peer1")
    private String sourcePeer;

    @Column(name = "peer2")
    private String targetPeer;
}
