package com.school.web_info.repository.impl;

import com.school.web_info.dto.filter.Filter;
import com.school.web_info.entity.questioner.Questioner;
import com.school.web_info.repository.StatsRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


@Repository
@RequiredArgsConstructor
public class DefaultStatsRepository implements StatsRepository {

    private final EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Questioner> findAllByFilter(Filter filter) {
        Session session = entityManager.unwrap(Session.class);

        if (Objects.nonNull(filter.city())) {
            session.enableFilter("cityFilter").setParameter("cityEquals", filter.city());
        }
        if (Objects.nonNull(filter.admission())) {
            session.enableFilter("admissionFilter").setParameter("admission", filter.admission());
        }
        if (Objects.nonNull(filter.educationInstitution())) {
            session.enableFilter("educationInstitutionFilter").setParameter("education", filter.educationInstitution());
        }
        if (Objects.nonNull(filter.facultyName())) {
            session.enableFilter("facultyFilter").setParameter("faculty", filter.facultyName());
        }

        if (Objects.nonNull(filter.cpp())) {
            session.enableFilter("cplusLevelFilter").setParameter("cpp", filter.cpp());
        }

        if (Objects.nonNull(filter.csharp())) {
            session.enableFilter("csharpLevelFilter").setParameter("csharp", filter.csharp());
        }

        if (Objects.nonNull(filter.python())) {
            session.enableFilter("pythonLevelFilter").setParameter("python", filter.python());
        }

        if (Objects.nonNull(filter.java())) {
            session.enableFilter("javaLevelFilter").setParameter("java", filter.java());
        }

        if (Objects.nonNull(filter.sql())) {
            session.enableFilter("sqlLevelFilter").setParameter("sql", filter.sql());
        }

        return entityManager.createQuery("""
                SELECT q FROM Questioner q
                JOIN FETCH q.user u
                JOIN FETCH q.faculty
                JOIN FETCH q.admission
                JOIN FETCH q.educationalInstitution
                """, Questioner.class).getResultList();
    }
}
