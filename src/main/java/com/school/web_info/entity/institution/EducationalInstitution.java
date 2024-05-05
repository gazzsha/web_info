package com.school.web_info.entity.institution;

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
@Table(name = "educational_institution")
@FilterDef(name = "educationInstitutionFilter", parameters = @ParamDef(name = "education", type = String.class))

@Filter(
        name = "educationInstitutionFilter",
        condition = "educational_institution = :education"
)
public class EducationalInstitution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    @Column(name = "educational_institution")
    private String institution;
}
