package com.school.web_info.entity.questioner;


import com.school.web_info.entity.User;
import com.school.web_info.entity.admission.Admission;
import com.school.web_info.entity.faculty.Faculty;
import com.school.web_info.entity.institution.EducationalInstitution;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "questionnaire")
public class Questioner {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;


    @OneToOne(orphanRemoval = false, optional = false)
    private User user;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id", referencedColumnName = "id")
    private Faculty faculty;

    @Column(name = "city")
    private String city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "educational_institution_id", referencedColumnName = "id")
    private EducationalInstitution educationalInstitution;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admission_id", referencedColumnName = "id")
    private Admission admission;

    @Column(name = "knowledge_level_c++", nullable = false)
    private Integer levelCpp;

    @Column(name = "knowledge_level_python", nullable = false)
    private Integer levelPython;

    @Column(name = "knowledge_level_java", nullable = false)
    private Integer levelJava;

    @Column(name = "knowledge_level_c#", nullable = false)
    private Integer levelCSharp;

    @Column(name = "knowledge_level_sql", nullable = false)
    private Integer levelSql;
}
