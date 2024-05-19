package com.school.web_info.entity.questioner;


import com.school.web_info.entity.user.User;
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
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

import java.sql.Date;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "questionnaire")
@FilterDefs({
        @FilterDef(
                name = "cityFilter",
                parameters = @ParamDef(name = "cityEquals", type = String.class)),
        @FilterDef(
                name = "cplusLevelFilter",
                parameters = @ParamDef(name = "cpp", type = int.class)),
        @FilterDef(
                name = "csharpLevelFilter",
                parameters = @ParamDef(name = "csharp", type = int.class)),
        @FilterDef(
                name = "pythonLevelFilter",
                parameters = @ParamDef(name = "python", type = int.class)),
        @FilterDef(
                name = "javaLevelFilter",
                parameters = @ParamDef(name = "java", type = int.class)),
        @FilterDef(
                name = "sqlLevelFilter",
                parameters = @ParamDef(name = "sql", type = int.class))}
)
@Filters({
        @Filter(
                name = "cityFilter",
                condition = "city = :cityEquals"),
        @Filter(
                name = "cplusLevelFilter",
                condition = "\"knowledge_level_c++\" = :cpp"
        ),
        @Filter(
                name = "csharpLevelFilter",
                condition = "\"knowledge_level_c#\" = :csharp"
        ),
        @Filter(
                name = "pythonLevelFilter",
                condition = "knowledge_level_python = :python"
        ),
        @Filter(
                name = "javaLevelFilter",
                condition = "knowledge_level_java = :java"
        ),
        @Filter(
                name = "sqlLevelFilter",
                condition = "knowledge_level_sql = :sql"
        )}
)
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
    @Filter(name = "facultyFilter")
    private Faculty faculty;

    @Column(name = "city")
    private String city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "educational_institution_id", referencedColumnName = "id")
    @Filter(name = "educationInstitutionFilter")
    private EducationalInstitution educationalInstitution;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admission_id", referencedColumnName = "id")
    @Filter(name = "admissionFilter")
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
