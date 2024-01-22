package com.school.web_info.dao;

import com.school.web_info.entity.TimeTracking;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TimeTrackingDAOImplementation implements TimeTrackingDAO {

    private final EntityManager entityManager;

    public TimeTrackingDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<TimeTracking> getAllTimeTracking(String nickname) {
        if (nickname != null) {
            Query query = entityManager.createQuery("select time from TimeTracking time where peerName =: nickname");
            query.setParameter("nickname", nickname);
            return query.getResultList();
        }
        Query query = entityManager.createQuery("SELECT time FROM TimeTracking time", TimeTracking.class);
        return query.getResultList();
    }

}
