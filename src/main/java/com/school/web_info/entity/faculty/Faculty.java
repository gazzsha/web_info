package com.school.web_info.entity.faculty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "faculty")
@FilterDef(name = "facultyFilter", parameters = @ParamDef(name = "faculty", type = String.class))

@Filter(
        name = "facultyFilter",
        condition = "faculty_name = :faculty"
)
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    @Column(name = "faculty_name", nullable = false)
    private String facultyName;
}
