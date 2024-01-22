package com.school.web_info.controller;

import com.school.web_info.entity.Peer;
import com.school.web_info.entity.Recommendations;
import com.school.web_info.service.PeerService;
import com.school.web_info.service.RecommendationsService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/school")
@AllArgsConstructor
public class ControllerRecommendations {


    private final RecommendationsService recommendationsService;

    private final PeerService peerService;

    @GetMapping("/recommendations")
    public String showAllRecommendations(Model model) {
        List<String> recommendationsList = recommendationsService.getAllUniquePeerRecommendations();
        model.addAttribute("recommendations", recommendationsList);
        return "recommendations/view";
    }

    @GetMapping("/recommendations/{nickname}")
    public String showAllRecommendedPeer(@PathVariable("nickname") String nickname, Model model) {
        List<String> listRecommendedPeer = recommendationsService.getAllRecommendedPeer(nickname);
        model.addAttribute("recommendedPeer", listRecommendedPeer);
        List<String> recommendationsList = recommendationsService.getAllUniquePeerRecommendations();
        model.addAttribute("recommendations", recommendationsList);
        return "recommendations/recommended-peers";
    }

    @RequestMapping(value = "/recommendations/deleteRecommendations", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteRecommendations(Recommendations recommendations) {
        String peer = recommendations.getPeer();
        recommendationsService.deleteRecommendations(recommendations);
        return "redirect:/school/recommendations/" + peer;
    }

    @RequestMapping(value = "/recommendations/addRecommendations",method = {RequestMethod.PUT,RequestMethod.GET})
    public String addRecomenndations(Recommendations recommendations) {
        String peer = recommendations.getPeer();
        recommendationsService.addRecommendations(recommendations);
        System.out.println(peer);
        return "redirect:/school/recommendations/" + peer;
    }

    @ModelAttribute("allPeers")
    public List<Peer> getAllPeers() {
        return peerService.getAllPeers();
    }


//    @ModelAttribute("recommendedPeer")
//    public List<String> strings() {
//        return recommendationsService.getAllRecommendedPeer("antoinco");
//    }

}
