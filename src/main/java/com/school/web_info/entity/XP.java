package com.school.web_info.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "xp")
@Getter
@Setter
@NoArgsConstructor
public class XP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private int id;

    @Column(name = "\"Check\"",insertable=false, updatable=false)
    @NotNull
    private int check;

    @Column(name = "xpamount")
    @NotNull
    private int xpamount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"Check\"")
    @JsonBackReference
    private Checks checks;




}
