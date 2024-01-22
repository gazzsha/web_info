package com.school.web_info.dao;

import com.school.web_info.entity.Recommendations;

import java.util.List;

public interface RecommendationsDAO {
    List<Recommendations> getAllRecommendations();

    List<String> getAllUniquePeerRecommendations();

    List<String> getAllRecommendedPeer(String nicknamePeer);

    void deleteRecommendations(Recommendations recommendations);

    void saveRecommendations(Recommendations recommendations);

}
