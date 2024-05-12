package com.school.web_info.repository.impl;

import com.school.web_info.dto.filter.FilterUser;
import com.school.web_info.entity.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl {

    private final EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<User> findAllByFilter(FilterUser filter) {
        Session session = entityManager.unwrap(Session.class);

        if (Objects.nonNull(filter)) {

            if (Objects.nonNull(filter.name())) {
                session.enableFilter("nameFilter").setParameter("nameUser", filter.name());
            }
            if (Objects.nonNull(filter.lastName())) {
                session.enableFilter("lastNameFilter").setParameter("lastNameUser", filter.lastName());
            }
        }

        return entityManager.createQuery("""
                select u from User u
                """, User.class).getResultList();
    }
}
