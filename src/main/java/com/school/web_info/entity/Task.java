package com.school.web_info.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "task")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @NotNull
    @Column(name = "title")
    private String taskName;

    @Column(name = "parenttask")
    private String parentTask;

    @Column(name = "maxxp")
    @NotNull
    private int maxXP;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "title")
    @JsonBackReference
    private Checks checks;

}
