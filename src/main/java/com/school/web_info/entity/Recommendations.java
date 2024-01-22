package com.school.web_info.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "recommendations")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Recommendations {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "peer")
    private String peer;

    @Column(name = "RecommendedPeer")
    private String recommendedPeer;
}
