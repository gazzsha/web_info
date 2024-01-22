package com.school.web_info.dao;

import com.school.web_info.entity.Recommendations;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class RecommendationsDAOImplementations implements RecommendationsDAO{

    private final EntityManager entityManager;
    @Override
    public List<Recommendations> getAllRecommendations() {
        Query query = entityManager.createQuery("select r from Recommendations  r", Recommendations.class);
        List<Recommendations> recommendationsList = query.getResultList();
        return recommendationsList;
    }

    @Override
    public List<String> getAllUniquePeerRecommendations() {
        Query query = entityManager.createQuery("select r.peer from Recommendations  r group by r.peer", Recommendations.class);
        List<String> recommendationsList = query.getResultList();
        return recommendationsList;
    }

    @Override
    public List<String> getAllRecommendedPeer(String nicknamePeer) {
        Query query = entityManager.createQuery("select r.recommendedPeer from Recommendations  r where r.peer = ?1", Recommendations.class);
        query.setParameter(1,nicknamePeer);
        List<String> recommendationsList = query.getResultList();
        return recommendationsList;
    }

    @Override
    public void deleteRecommendations(Recommendations recommendations) {
        Query query = entityManager.createQuery("delete from Recommendations  r where r.peer = ?1 and r.recommendedPeer=?2");
        query.setParameter(1,recommendations.getPeer());
        query.setParameter(2,recommendations.getRecommendedPeer());
        query.executeUpdate();
    }

    @Override
    public void saveRecommendations(Recommendations recommendations) {
        entityManager.merge(recommendations);
    }
}
