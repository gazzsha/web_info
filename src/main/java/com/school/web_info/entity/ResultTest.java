package com.school.web_info.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "result_test")
public class ResultTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "test_id", nullable = false, updatable = false)
    private String testId;

    @Column(name = "count_true_answer", nullable = false)
    private Long countTrueAnswer;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
