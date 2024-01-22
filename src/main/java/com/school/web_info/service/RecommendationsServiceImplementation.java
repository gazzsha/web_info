package com.school.web_info.service;

import com.school.web_info.dao.RecommendationsDAO;
import com.school.web_info.entity.Recommendations;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class RecommendationsServiceImplementation implements RecommendationsService{

    private final RecommendationsDAO recommendationsDAO;
    @Override
    @Transactional
    public List<Recommendations> getAllRecommendations() {
        return recommendationsDAO.getAllRecommendations();
    }

    @Override
    @Transactional
    public List<String> getAllUniquePeerRecommendations() {
        return recommendationsDAO.getAllUniquePeerRecommendations();
    }

    @Override
    @Transactional
    public List<String> getAllRecommendedPeer(String nicknamePeer) {
        return recommendationsDAO.getAllRecommendedPeer(nicknamePeer);
    }

    @Override
    @Transactional
    public void deleteRecommendations(Recommendations recommendations) {
        recommendationsDAO.deleteRecommendations(recommendations);
    }

    @Override
    @Transactional
    public void addRecommendations(Recommendations recommendations) {
        recommendationsDAO.saveRecommendations(recommendations);
    }
}
