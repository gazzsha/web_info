package com.school.web_info.service;

import com.school.web_info.entity.Recommendations;

import java.util.List;

public interface RecommendationsService {

    List<Recommendations> getAllRecommendations();

    List<String> getAllUniquePeerRecommendations();
    List<String> getAllRecommendedPeer(String nicknamePeer);

    void deleteRecommendations(Recommendations recommendations);

    void addRecommendations(Recommendations recommendations);

}
