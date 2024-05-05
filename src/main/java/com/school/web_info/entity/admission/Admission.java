package com.school.web_info.entity.admission;

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
@Table(name = "admission")
@FilterDef(name = "admissionFilter", parameters = @ParamDef(name = "admission", type = String.class))

@Filter(
        name = "admissionFilter",
        condition = "admission = :admission"
)
public class Admission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    @Column(name = "admission")
    private String admissionVariant;
}
